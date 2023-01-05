package org.fd.project.shared.openfeign.jsonplaceholder;

import java.util.List;
import org.fd.project.shared.openfeign.jsonplaceholder.request.CreatePostRequest;
import org.fd.project.shared.openfeign.jsonplaceholder.response.PostResponse;
import org.springframework.stereotype.Component;

@Component
public class JsonPlaceHolderClientFallback implements JsonPlaceHolderClient{

  /**
   * When Open feign Call failed, then do this
   */
  @Override
  public List<PostResponse> getListPost() {
    return null;
  }

  @Override
  public PostResponse getPostById(String id) {
    return null;
  }

  @Override
  public PostResponse createPost(CreatePostRequest createPostRequest) {
    return null;
  }
}
