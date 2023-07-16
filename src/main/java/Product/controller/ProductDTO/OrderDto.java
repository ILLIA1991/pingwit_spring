package Product.controller.ProductDTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderDto {

    private Integer id;
    private UserDTO user;
    private Date createdAt;
    private String comment;
    private List<OrderItemDto> orderItems = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() !=o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(id, orderDto.id) && Objects.equals(user, orderDto.user) && Objects.equals(createdAt, orderDto.createdAt) && Objects.equals(comment, orderDto.comment) && Objects.equals(orderItems, orderDto.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, createdAt, comment, orderItems);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", user=" + user +
                ", createdAt=" + createdAt +
                ", comment='" + comment + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}