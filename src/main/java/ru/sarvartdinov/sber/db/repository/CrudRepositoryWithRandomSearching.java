package ru.sarvartdinov.sber.db.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface CrudRepositoryWithRandomSearching<T, ID> extends PagingAndSortingRepository<T, ID> {

    /**
     * Найти рандомную сущность из таблицы
     *
     * @return сущность
     */
    @Transactional
    default T findRandom() {
        long count = this.count();
        int idx = (int)(Math.random() * count);
        Page<T> questionPage = this.findAll(PageRequest.of(idx, 1));
        T q = null;
        if (questionPage.hasContent()) {
            q = questionPage.getContent().get(0);
        }
        return q;
    }

}
