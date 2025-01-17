package com.docusign.esign.model;

import java.util.Objects;
import java.util.Arrays;
import com.docusign.esign.model.NameValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CustomSettingsInformation.
 *
 */

public class CustomSettingsInformation {
  @JsonProperty("customSettings")
  private java.util.List<NameValue> customSettings = null;


  /**
   * customSettings.
   *
   * @return CustomSettingsInformation
   **/
  public CustomSettingsInformation customSettings(java.util.List<NameValue> customSettings) {
    this.customSettings = customSettings;
    return this;
  }
  
  /**
   * addCustomSettingsItem.
   *
   * @return CustomSettingsInformation
   **/
  public CustomSettingsInformation addCustomSettingsItem(NameValue customSettingsItem) {
    if (this.customSettings == null) {
      this.customSettings = new java.util.ArrayList<>();
    }
    this.customSettings.add(customSettingsItem);
    return this;
  }

  /**
   * .
   * @return customSettings
   **/
  @ApiModelProperty(value = "")
  public java.util.List<NameValue> getCustomSettings() {
    return customSettings;
  }

  /**
   * setCustomSettings.
   **/
  public void setCustomSettings(java.util.List<NameValue> customSettings) {
    this.customSettings = customSettings;
  }


  /**
   * Compares objects.
   *
   * @return true or false depending on comparison result.
   */
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomSettingsInformation customSettingsInformation = (CustomSettingsInformation) o;
    return Objects.equals(this.customSettings, customSettingsInformation.customSettings);
  }

  /**
   * Returns the HashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(customSettings);
  }


  /**
   * Converts the given object to string.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomSettingsInformation {\n");
    
    sb.append("    customSettings: ").append(toIndentedString(customSettings)).append("\n");
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

