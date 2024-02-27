package com.rafikben.urlshortner;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Url {
    @Id
    private String id;

    private  String url;

    public Url(String url) {
        this.url = url;
    }

    public void setId(String id) {
		this.id = id;
	}

	public Url() {}

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
