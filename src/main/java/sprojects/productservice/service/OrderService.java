package sprojects.productservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sprojects.productservice.dto.OrderLineItemsDto;
import sprojects.productservice.dto.OrderRequest;
import sprojects.productservice.model.Order;
import sprojects.productservice.model.OrderLineItems;
import sprojects.productservice.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;

	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
					.stream()
					.map(this::mapToDto)
					.toList();
		 order.setOrderLineItemsList(orderLineItems);
		 
		 orderRepository.save(order);
		
		
	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItems.getQuantity());
		orderLineItems.setSkuCode(orderLineItems.getSkuCode());
		return orderLineItems;
	}
}
