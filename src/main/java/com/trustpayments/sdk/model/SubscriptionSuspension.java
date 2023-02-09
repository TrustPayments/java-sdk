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
import com.trustpayments.sdk.model.SubscriptionSuspensionAction;
import com.trustpayments.sdk.model.SubscriptionSuspensionReason;
import com.trustpayments.sdk.model.SubscriptionSuspensionState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.*;
import java.time.OffsetDateTime;

/**
 * 
 */
@ApiModel(description = "")

public class SubscriptionSuspension {
  
  @JsonProperty("createdOn")
  protected OffsetDateTime createdOn = null;

  
  @JsonProperty("effectiveEndDate")
  protected OffsetDateTime effectiveEndDate = null;

  
  @JsonProperty("endAction")
  protected SubscriptionSuspensionAction endAction = null;

  
  @JsonProperty("id")
  protected Long id = null;

  
  @JsonProperty("language")
  protected String language = null;

  
  @JsonProperty("linkedSpaceId")
  protected Long linkedSpaceId = null;

  
  @JsonProperty("note")
  protected String note = null;

  
  @JsonProperty("periodBill")
  protected Long periodBill = null;

  
  @JsonProperty("plannedEndDate")
  protected OffsetDateTime plannedEndDate = null;

  
  @JsonProperty("plannedPurgeDate")
  protected OffsetDateTime plannedPurgeDate = null;

  
  @JsonProperty("reason")
  protected SubscriptionSuspensionReason reason = null;

  
  @JsonProperty("state")
  protected SubscriptionSuspensionState state = null;

  
  @JsonProperty("subscription")
  protected Long subscription = null;

  
  @JsonProperty("version")
  protected Integer version = null;

  
  
   /**
   * The date and time when the object was created.
   * @return createdOn
  **/
  @ApiModelProperty(value = "The date and time when the object was created.")
  public OffsetDateTime getCreatedOn() {
    return createdOn;
  }

  
   /**
   * 
   * @return effectiveEndDate
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getEffectiveEndDate() {
    return effectiveEndDate;
  }

  
   /**
   * When the suspension reaches the planned end date the end action will be carried out. This action is only executed when the suspension is ended automatically based on the end date.
   * @return endAction
  **/
  @ApiModelProperty(value = "When the suspension reaches the planned end date the end action will be carried out. This action is only executed when the suspension is ended automatically based on the end date.")
  public SubscriptionSuspensionAction getEndAction() {
    return endAction;
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
   * The language that is linked to the object.
   * @return language
  **/
  @ApiModelProperty(value = "The language that is linked to the object.")
  public String getLanguage() {
    return language;
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
   * The note may contain some internal information for the suspension. The note will not be disclosed to the subscriber.
   * @return note
  **/
  @ApiModelProperty(value = "The note may contain some internal information for the suspension. The note will not be disclosed to the subscriber.")
  public String getNote() {
    return note;
  }

  
   /**
   * 
   * @return periodBill
  **/
  @ApiModelProperty(value = "")
  public Long getPeriodBill() {
    return periodBill;
  }

  
   /**
   * The planned end date of the suspension identifies the date on which the suspension will be ended automatically.
   * @return plannedEndDate
  **/
  @ApiModelProperty(value = "The planned end date of the suspension identifies the date on which the suspension will be ended automatically.")
  public OffsetDateTime getPlannedEndDate() {
    return plannedEndDate;
  }

  
   /**
   * The date and time when the object is planned to be permanently removed. If the value is empty, the object will not be removed.
   * @return plannedPurgeDate
  **/
  @ApiModelProperty(value = "The date and time when the object is planned to be permanently removed. If the value is empty, the object will not be removed.")
  public OffsetDateTime getPlannedPurgeDate() {
    return plannedPurgeDate;
  }

  
   /**
   * The suspension reason indicates why a suspension has been created.
   * @return reason
  **/
  @ApiModelProperty(value = "The suspension reason indicates why a suspension has been created.")
  public SubscriptionSuspensionReason getReason() {
    return reason;
  }

  
   /**
   * The object&#39;s current state.
   * @return state
  **/
  @ApiModelProperty(value = "The object's current state.")
  public SubscriptionSuspensionState getState() {
    return state;
  }

  
   /**
   * 
   * @return subscription
  **/
  @ApiModelProperty(value = "")
  public Long getSubscription() {
    return subscription;
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
    SubscriptionSuspension subscriptionSuspension = (SubscriptionSuspension) o;
    return Objects.equals(this.createdOn, subscriptionSuspension.createdOn) &&
        Objects.equals(this.effectiveEndDate, subscriptionSuspension.effectiveEndDate) &&
        Objects.equals(this.endAction, subscriptionSuspension.endAction) &&
        Objects.equals(this.id, subscriptionSuspension.id) &&
        Objects.equals(this.language, subscriptionSuspension.language) &&
        Objects.equals(this.linkedSpaceId, subscriptionSuspension.linkedSpaceId) &&
        Objects.equals(this.note, subscriptionSuspension.note) &&
        Objects.equals(this.periodBill, subscriptionSuspension.periodBill) &&
        Objects.equals(this.plannedEndDate, subscriptionSuspension.plannedEndDate) &&
        Objects.equals(this.plannedPurgeDate, subscriptionSuspension.plannedPurgeDate) &&
        Objects.equals(this.reason, subscriptionSuspension.reason) &&
        Objects.equals(this.state, subscriptionSuspension.state) &&
        Objects.equals(this.subscription, subscriptionSuspension.subscription) &&
        Objects.equals(this.version, subscriptionSuspension.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdOn, effectiveEndDate, endAction, id, language, linkedSpaceId, note, periodBill, plannedEndDate, plannedPurgeDate, reason, state, subscription, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionSuspension {\n");
    
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    effectiveEndDate: ").append(toIndentedString(effectiveEndDate)).append("\n");
    sb.append("    endAction: ").append(toIndentedString(endAction)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    linkedSpaceId: ").append(toIndentedString(linkedSpaceId)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    periodBill: ").append(toIndentedString(periodBill)).append("\n");
    sb.append("    plannedEndDate: ").append(toIndentedString(plannedEndDate)).append("\n");
    sb.append("    plannedPurgeDate: ").append(toIndentedString(plannedPurgeDate)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
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

