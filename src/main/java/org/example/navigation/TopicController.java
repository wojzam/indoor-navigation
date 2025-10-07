package org.example.navigation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/topic")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<Topic> getTopics() {
        return topicService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable UUID id) {
        try {
            Topic topic = topicService.findById(id);
            return ResponseEntity.ok(topic);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Topic> save(@RequestBody Topic topic) {
        Topic savedTopic = topicService.save(topic);
        return ResponseEntity.ok(savedTopic);
    }

    @PutMapping("{id}")
    public ResponseEntity<Topic> update(@PathVariable UUID id, @RequestBody Topic topic) {
        try {
            topic.setId(id);
            Topic updatedTopic = topicService.update(topic);
            return ResponseEntity.ok(updatedTopic);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        try {
            topicService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
