package com.deba.movieInfo.Reposotory;

import com.deba.movieInfo.entity.AboutMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepo extends JpaRepository<AboutMovie,Integer> {

}
