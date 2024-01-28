package com.app.slackdame.repository;

import com.app.slackdame.entity.Channel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends CrudRepository<Channel, Long> {
}
