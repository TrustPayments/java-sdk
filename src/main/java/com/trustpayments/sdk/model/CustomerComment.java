/**
* Trust Payments SDK
*
* This library allows to interact with the Trust Payments payment service.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/


package com.trustpayments.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.*;
import java.time.OffsetDateTime;

/**
 * 
 */
@ApiModel(description = "")

public class CustomerComment {
  
  @JsonProperty("content")
  protected String content = null;

  
  @JsonProperty("createdBy")
  protected Long createdBy = null;

  
  @JsonProperty("createdOn")
  protected OffsetDateTime createdOn = null;

  
  @JsonProperty("customer")
  protected Long customer = null;

  
  @JsonProperty("editedBy")
  protected Long editedBy = null;

  
  @JsonProperty("editedOn")
  protected OffsetDateTime editedOn = null;

  
  @JsonProperty("id")
  protected Long id = null;

  
  @JsonProperty("linkedSpaceId")
  protected Long linkedSpaceId = null;

  
  @JsonProperty("pinned")
  protected Boolean pinned = null;

  
  @JsonProperty("version")
  protected Integer version = null;

  
  
   /**
   * The comment&#39;s actual content.
   * @return content
  **/
  @ApiModelProperty(value = "The comment's actual content.")
  public String getContent() {
    return content;
  }

  
   /**
   * The ID of the user the comment was created by.
   * @return createdBy
  **/
  @ApiModelProperty(value = "The ID of the user the comment was created by.")
  public Long getCreatedBy() {
    return createdBy;
  }

  
   /**
   * The date and time when the object was created.
   * @return createdOn
  **/
  @ApiModelProperty(value = "The date and time when the object was created.")
  public OffsetDateTime getCreatedOn() {
    return createdOn;
  }

  
   /**
   * The customer that the object belongs to.
   * @return customer
  **/
  @ApiModelProperty(value = "The customer that the object belongs to.")
  public Long getCustomer() {
    return customer;
  }

  
   /**
   * The ID of the user the comment was last updated by.
   * @return editedBy
  **/
  @ApiModelProperty(value = "The ID of the user the comment was last updated by.")
  public Long getEditedBy() {
    return editedBy;
  }

  
   /**
   * The date and time when the comment was last updated.
   * @return editedOn
  **/
  @ApiModelProperty(value = "The date and time when the comment was last updated.")
  public OffsetDateTime getEditedOn() {
    return editedOn;
  }

  
   /**
   * A unique identifier for the object.
   * @return id
  **/
  @ApiModelProperty(value = "A unique identifier for the object.")
  public Long getId() {
    return id;
  }

  
   /**
   * The ID of the space this object belongs to.
   * @return linkedSpaceId
  **/
  @ApiModelProperty(value = "The ID of the space this object belongs to.")
  public Long getLinkedSpaceId() {
    return linkedSpaceId;
  }

  
   /**
   * Whether the comment is pinned to the top.
   * @return pinned
  **/
  @ApiModelProperty(value = "Whether the comment is pinned to the top.")
  public Boolean isPinned() {
    return pinned;
  }

  
   /**
   * The version is used for optimistic locking and incremented whenever the object is updated.
   * @return version
  **/
  @ApiModelProperty(value = "The version is used for optimistic locking and incremented whenever the object is updated.")
  public Integer getVersion() {
    return version;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerComment customerComment = (CustomerComment) o;
    return Objects.equals(this.content, customerComment.content) &&
        Objects.equals(this.createdBy, customerComment.createdBy) &&
        Objects.equals(this.createdOn, customerComment.createdOn) &&
        Objects.equals(this.customer, customerComment.customer) &&
        Objects.equals(this.editedBy, customerComment.editedBy) &&
        Objects.equals(this.editedOn, customerComment.editedOn) &&
        Objects.equals(this.id, customerComment.id) &&
        Objects.equals(this.linkedSpaceId, customerComment.linkedSpaceId) &&
        Objects.equals(this.pinned, customerComment.pinned) &&
        Objects.equals(this.version, customerComment.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, createdBy, createdOn, customer, editedBy, editedOn, id, linkedSpaceId, pinned, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerComment {\n");
    
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    editedBy: ").append(toIndentedString(editedBy)).append("\n");
    sb.append("    editedOn: ").append(toIndentedString(editedOn)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    linkedSpaceId: ").append(toIndentedString(linkedSpaceId)).append("\n");
    sb.append("    pinned: ").append(toIndentedString(pinned)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

