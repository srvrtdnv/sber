package ru.sarvartdinov.sber.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * Сущность имитации сообщения
 */
@Entity(name = "messages")
@Data
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "message_text")
    private String messageText;

    public MessageEntity() {

    }

    /**
     * Конструктор
     * @param email адресат сообщения
     * @param messageText текст сообщения
     */
    public MessageEntity(String email, String messageText) {
        this.email = email;
        this.messageText = messageText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return Objects.equals(email, that.email) && Objects.equals(messageText, that.messageText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, messageText);
    }
}
