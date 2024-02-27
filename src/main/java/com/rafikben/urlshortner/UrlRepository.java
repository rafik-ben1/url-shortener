package com.rafikben.urlshortner;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository <Url, String> {
	public Optional<Url> findByUrl(String url);
}
