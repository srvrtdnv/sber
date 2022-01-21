package ru.sarvartdinov.sber.db.repository;

import org.springframework.stereotype.Repository;
import ru.sarvartdinov.sber.db.entity.GroupEntity;

@Repository
public interface GroupsCrudRepository extends CrudRepositoryWithRandomSearching<GroupEntity, String> {
}
