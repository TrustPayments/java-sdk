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
import com.trustpayments.sdk.model.CreationEntityState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.*;
import java.time.OffsetDateTime;

/**
 * 
 */
@ApiModel(description = "")

public class Token {
  
  @JsonProperty("createdOn")
  protected OffsetDateTime createdOn = null;

  
  @JsonProperty("customerEmailAddress")
  protected String customerEmailAddress = null;

  
  @JsonProperty("customerId")
  protected String customerId = null;

  
  @JsonProperty("enabledForOneClickPayment")
  protected Boolean enabledForOneClickPayment = null;

  
  @JsonProperty("externalId")
  protected String externalId = null;

  
  @JsonProperty("id")
  protected Long id = null;

  
  @JsonProperty("language")
  protected String language = null;

  
  @JsonProperty("linkedSpaceId")
  protected Long linkedSpaceId = null;

  
  @JsonProperty("plannedPurgeDate")
  protected OffsetDateTime plannedPurgeDate = null;

  
  @JsonProperty("state")
  protected CreationEntityState state = null;

  
  @JsonProperty("timeZone")
  protected String timeZone = null;

  
  @JsonProperty("tokenReference")
  protected String tokenReference = null;

  
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
   * The customer email address is the email address of the customer.
   * @return customerEmailAddress
  **/
  @ApiModelProperty(value = "The customer email address is the email address of the customer.")
  public String getCustomerEmailAddress() {
    return customerEmailAddress;
  }

  
   /**
   * The customer ID identifies the customer in the merchant system. In case the customer ID has been provided it has to correspond with the customer ID provided on the transaction. The customer ID will not be changed automatically. The merchant system has to provide it.
   * @return customerId
  **/
  @ApiModelProperty(value = "The customer ID identifies the customer in the merchant system. In case the customer ID has been provided it has to correspond with the customer ID provided on the transaction. The customer ID will not be changed automatically. The merchant system has to provide it.")
  public String getCustomerId() {
    return customerId;
  }

  
   /**
   * When a token is enabled for one-click payments the buyer will be able to select the token within the iFrame or on the payment page to pay with the token. The usage of the token will reduce the number of steps the buyer has to go through. The buyer is linked via the customer ID on the transaction with the token. Means the token will be visible for buyers with the same customer ID. Additionally the payment method has to be configured to allow the one-click payments.
   * @return enabledForOneClickPayment
  **/
  @ApiModelProperty(value = "When a token is enabled for one-click payments the buyer will be able to select the token within the iFrame or on the payment page to pay with the token. The usage of the token will reduce the number of steps the buyer has to go through. The buyer is linked via the customer ID on the transaction with the token. Means the token will be visible for buyers with the same customer ID. Additionally the payment method has to be configured to allow the one-click payments.")
  public Boolean isEnabledForOneClickPayment() {
    return enabledForOneClickPayment;
  }

  
   /**
   * A client generated nonce which identifies the entity to be created. Subsequent creation requests with the same external ID will not create new entities but return the initially created entity instead.
   * @return externalId
  **/
  @ApiModelProperty(value = "A client generated nonce which identifies the entity to be created. Subsequent creation requests with the same external ID will not create new entities but return the initially created entity instead.")
  public String getExternalId() {
    return externalId;
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
   * The date and time when the object is planned to be permanently removed. If the value is empty, the object will not be removed.
   * @return plannedPurgeDate
  **/
  @ApiModelProperty(value = "The date and time when the object is planned to be permanently removed. If the value is empty, the object will not be removed.")
  public OffsetDateTime getPlannedPurgeDate() {
    return plannedPurgeDate;
  }

  
   /**
   * The object&#39;s current state.
   * @return state
  **/
  @ApiModelProperty(value = "The object's current state.")
  public CreationEntityState getState() {
    return state;
  }

  
   /**
   * The time zone defines in which time zone the customer is located in. The time zone may affects how dates are formatted when interacting with the customer.
   * @return timeZone
  **/
  @ApiModelProperty(value = "The time zone defines in which time zone the customer is located in. The time zone may affects how dates are formatted when interacting with the customer.")
  public String getTimeZone() {
    return timeZone;
  }

  
   /**
   * Use something that it is easy to identify and may help you find the token (e.g. customer id, email address).
   * @return tokenReference
  **/
  @ApiModelProperty(value = "Use something that it is easy to identify and may help you find the token (e.g. customer id, email address).")
  public String getTokenReference() {
    return tokenReference;
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
    Token token = (Token) o;
    return Objects.equals(this.createdOn, token.createdOn) &&
        Objects.equals(this.customerEmailAddress, token.customerEmailAddress) &&
        Objects.equals(this.customerId, token.customerId) &&
        Objects.equals(this.enabledForOneClickPayment, token.enabledForOneClickPayment) &&
        Objects.equals(this.externalId, token.externalId) &&
        Objects.equals(this.id, token.id) &&
        Objects.equals(this.language, token.language) &&
        Objects.equals(this.linkedSpaceId, token.linkedSpaceId) &&
        Objects.equals(this.plannedPurgeDate, token.plannedPurgeDate) &&
        Objects.equals(this.state, token.state) &&
        Objects.equals(this.timeZone, token.timeZone) &&
        Objects.equals(this.tokenReference, token.tokenReference) &&
        Objects.equals(this.version, token.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdOn, customerEmailAddress, customerId, enabledForOneClickPayment, externalId, id, language, linkedSpaceId, plannedPurgeDate, state, timeZone, tokenReference, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    customerEmailAddress: ").append(toIndentedString(customerEmailAddress)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    enabledForOneClickPayment: ").append(toIndentedString(enabledForOneClickPayment)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    linkedSpaceId: ").append(toIndentedString(linkedSpaceId)).append("\n");
    sb.append("    plannedPurgeDate: ").append(toIndentedString(plannedPurgeDate)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
    sb.append("    tokenReference: ").append(toIndentedString(tokenReference)).append("\n");
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

