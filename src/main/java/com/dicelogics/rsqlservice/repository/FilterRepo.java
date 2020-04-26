package com.dicelogics.rsqlservice.repository;

import java.util.List;

public interface FilterRepo<E> {
    List<E> findByQuery(String rQuery);
}
