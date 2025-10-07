package org.example.navigation;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public Topic findById(UUID id) {
        return topicRepository.findById(id).orElseThrow();
    }

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic update(Topic topic) {
        return topicRepository.save(topic);
    }

    public void delete(UUID id) {
        topicRepository.deleteById(id);
    }

}
