package ru.sarvartdinov.sber.db.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sarvartdinov.sber.db.entity.MessageEntity;

public interface MessageCrudRepository extends CrudRepository<MessageEntity, Long> {
}
