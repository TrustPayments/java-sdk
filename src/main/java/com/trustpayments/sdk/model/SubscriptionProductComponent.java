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
import com.trustpayments.sdk.model.SubscriptionProductComponentGroup;
import com.trustpayments.sdk.model.SubscriptionProductComponentReference;
import com.trustpayments.sdk.model.TaxClass;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.time.OffsetDateTime;

/**
 * 
 */
@ApiModel(description = "")

public class SubscriptionProductComponent {
  
  @JsonProperty("componentChangeWeight")
  protected Integer componentChangeWeight = null;

  
  @JsonProperty("componentGroup")
  protected SubscriptionProductComponentGroup componentGroup = null;

  
  @JsonProperty("defaultComponent")
  protected Boolean defaultComponent = null;

  
  @JsonProperty("description")
  protected Map<String, String> description = null;

  
  @JsonProperty("id")
  protected Long id = null;

  
  @JsonProperty("linkedSpaceId")
  protected Long linkedSpaceId = null;

  
  @JsonProperty("maximalQuantity")
  protected BigDecimal maximalQuantity = null;

  
  @JsonProperty("minimalQuantity")
  protected BigDecimal minimalQuantity = null;

  
  @JsonProperty("name")
  protected Map<String, String> name = null;

  
  @JsonProperty("quantityStep")
  protected BigDecimal quantityStep = null;

  
  @JsonProperty("reference")
  protected SubscriptionProductComponentReference reference = null;

  
  @JsonProperty("sortOrder")
  protected Integer sortOrder = null;

  
  @JsonProperty("taxClass")
  protected TaxClass taxClass = null;

  
  @JsonProperty("version")
  protected Integer version = null;

  
  
   /**
   * If a product component changes from one with a lower product component tier (e.g. 1) to one with a higher product component tier (e.g. 3), it is considered an upgrade and a one-time fee could be applied.
   * @return componentChangeWeight
  **/
  @ApiModelProperty(value = "If a product component changes from one with a lower product component tier (e.g. 1) to one with a higher product component tier (e.g. 3), it is considered an upgrade and a one-time fee could be applied.")
  public Integer getComponentChangeWeight() {
    return componentChangeWeight;
  }

  
   /**
   * 
   * @return componentGroup
  **/
  @ApiModelProperty(value = "")
  public SubscriptionProductComponentGroup getComponentGroup() {
    return componentGroup;
  }

  
   /**
   * When a component is marked as a &#39;default&#39; component it is used as the default component in its group and will be preselected in the product configuration.
   * @return defaultComponent
  **/
  @ApiModelProperty(value = "When a component is marked as a 'default' component it is used as the default component in its group and will be preselected in the product configuration.")
  public Boolean isDefaultComponent() {
    return defaultComponent;
  }

  
   /**
   * The component description may contain a longer description which gives the subscriber a better understanding of what the component contains.
   * @return description
  **/
  @ApiModelProperty(value = "The component description may contain a longer description which gives the subscriber a better understanding of what the component contains.")
  public Map<String, String> getDescription() {
    return description;
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
   * The maximum quantity defines the maximum value which must be entered for the quantity.
   * @return maximalQuantity
  **/
  @ApiModelProperty(value = "The maximum quantity defines the maximum value which must be entered for the quantity.")
  public BigDecimal getMaximalQuantity() {
    return maximalQuantity;
  }

  
   /**
   * The minimal quantity defines the minimum value which must be entered for the quantity.
   * @return minimalQuantity
  **/
  @ApiModelProperty(value = "The minimal quantity defines the minimum value which must be entered for the quantity.")
  public BigDecimal getMinimalQuantity() {
    return minimalQuantity;
  }

  
   /**
   * The component name is shown to the subscriber. It should describe in few words what the component does contain.
   * @return name
  **/
  @ApiModelProperty(value = "The component name is shown to the subscriber. It should describe in few words what the component does contain.")
  public Map<String, String> getName() {
    return name;
  }

  
   /**
   * The quantity step defines at which interval the quantity can be increased.
   * @return quantityStep
  **/
  @ApiModelProperty(value = "The quantity step defines at which interval the quantity can be increased.")
  public BigDecimal getQuantityStep() {
    return quantityStep;
  }

  
   /**
   * The component reference is used to identify the component by external systems and it marks components to represent the same component within different product versions.
   * @return reference
  **/
  @ApiModelProperty(value = "The component reference is used to identify the component by external systems and it marks components to represent the same component within different product versions.")
  public SubscriptionProductComponentReference getReference() {
    return reference;
  }

  
   /**
   * The sort order controls in which order the component is listed. The sort order is used to order the components in ascending order.
   * @return sortOrder
  **/
  @ApiModelProperty(value = "The sort order controls in which order the component is listed. The sort order is used to order the components in ascending order.")
  public Integer getSortOrder() {
    return sortOrder;
  }

  
   /**
   * The tax class of the component determines the taxes which are applicable on all fees linked with the component.
   * @return taxClass
  **/
  @ApiModelProperty(value = "The tax class of the component determines the taxes which are applicable on all fees linked with the component.")
  public TaxClass getTaxClass() {
    return taxClass;
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
    SubscriptionProductComponent subscriptionProductComponent = (SubscriptionProductComponent) o;
    return Objects.equals(this.componentChangeWeight, subscriptionProductComponent.componentChangeWeight) &&
        Objects.equals(this.componentGroup, subscriptionProductComponent.componentGroup) &&
        Objects.equals(this.defaultComponent, subscriptionProductComponent.defaultComponent) &&
        Objects.equals(this.description, subscriptionProductComponent.description) &&
        Objects.equals(this.id, subscriptionProductComponent.id) &&
        Objects.equals(this.linkedSpaceId, subscriptionProductComponent.linkedSpaceId) &&
        Objects.equals(this.maximalQuantity, subscriptionProductComponent.maximalQuantity) &&
        Objects.equals(this.minimalQuantity, subscriptionProductComponent.minimalQuantity) &&
        Objects.equals(this.name, subscriptionProductComponent.name) &&
        Objects.equals(this.quantityStep, subscriptionProductComponent.quantityStep) &&
        Objects.equals(this.reference, subscriptionProductComponent.reference) &&
        Objects.equals(this.sortOrder, subscriptionProductComponent.sortOrder) &&
        Objects.equals(this.taxClass, subscriptionProductComponent.taxClass) &&
        Objects.equals(this.version, subscriptionProductComponent.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(componentChangeWeight, componentGroup, defaultComponent, description, id, linkedSpaceId, maximalQuantity, minimalQuantity, name, quantityStep, reference, sortOrder, taxClass, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionProductComponent {\n");
    
    sb.append("    componentChangeWeight: ").append(toIndentedString(componentChangeWeight)).append("\n");
    sb.append("    componentGroup: ").append(toIndentedString(componentGroup)).append("\n");
    sb.append("    defaultComponent: ").append(toIndentedString(defaultComponent)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    linkedSpaceId: ").append(toIndentedString(linkedSpaceId)).append("\n");
    sb.append("    maximalQuantity: ").append(toIndentedString(maximalQuantity)).append("\n");
    sb.append("    minimalQuantity: ").append(toIndentedString(minimalQuantity)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    quantityStep: ").append(toIndentedString(quantityStep)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    sortOrder: ").append(toIndentedString(sortOrder)).append("\n");
    sb.append("    taxClass: ").append(toIndentedString(taxClass)).append("\n");
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

