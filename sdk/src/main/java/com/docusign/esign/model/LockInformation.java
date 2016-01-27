package com.docusign.esign.model;

import java.util.Objects;
import com.docusign.esign.model.ErrorDetails;
import com.docusign.esign.model.UserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-01-18T16:25:36.433-08:00")
public class LockInformation   {
  
  private UserInfo lockedByUser = null;
  private String lockedByApp = null;
  private String lockedUntilDateTime = null;
  private String lockDurationInSeconds = null;
  private String lockType = null;
  private String useScratchPad = null;
  private String lockToken = null;
  private ErrorDetails errorDetails = null;

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("lockedByUser")
  public UserInfo getLockedByUser() {
    return lockedByUser;
  }
  public void setLockedByUser(UserInfo lockedByUser) {
    this.lockedByUser = lockedByUser;
  }

  
  /**
   * Specifies the friendly name of  the application that is locking the envelope.
   **/
  
  @ApiModelProperty(value = "Specifies the friendly name of  the application that is locking the envelope.")
  @JsonProperty("lockedByApp")
  public String getLockedByApp() {
    return lockedByApp;
  }
  public void setLockedByApp(String lockedByApp) {
    this.lockedByApp = lockedByApp;
  }

  
  /**
   * 
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("lockedUntilDateTime")
  public String getLockedUntilDateTime() {
    return lockedUntilDateTime;
  }
  public void setLockedUntilDateTime(String lockedUntilDateTime) {
    this.lockedUntilDateTime = lockedUntilDateTime;
  }

  
  /**
   * Sets the time, in seconds, until the lock expires when there is no activity on the envelope.\n\nIf no value is entered, then the default value of 300 seconds is used. The maximum value is 1,800 seconds.\n\nThe lock duration can be extended.
   **/
  
  @ApiModelProperty(value = "Sets the time, in seconds, until the lock expires when there is no activity on the envelope.\n\nIf no value is entered, then the default value of 300 seconds is used. The maximum value is 1,800 seconds.\n\nThe lock duration can be extended.")
  @JsonProperty("lockDurationInSeconds")
  public String getLockDurationInSeconds() {
    return lockDurationInSeconds;
  }
  public void setLockDurationInSeconds(String lockDurationInSeconds) {
    this.lockDurationInSeconds = lockDurationInSeconds;
  }

  
  /**
   * 
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("lockType")
  public String getLockType() {
    return lockType;
  }
  public void setLockType(String lockType) {
    this.lockType = lockType;
  }

  
  /**
   * Reserved for future use.\n\nIndicates whether a scratchpad is used for editing information.
   **/
  
  @ApiModelProperty(value = "Reserved for future use.\n\nIndicates whether a scratchpad is used for editing information.")
  @JsonProperty("useScratchPad")
  public String getUseScratchPad() {
    return useScratchPad;
  }
  public void setUseScratchPad(String useScratchPad) {
    this.useScratchPad = useScratchPad;
  }

  
  /**
   * 
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("lockToken")
  public String getLockToken() {
    return lockToken;
  }
  public void setLockToken(String lockToken) {
    this.lockToken = lockToken;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("errorDetails")
  public ErrorDetails getErrorDetails() {
    return errorDetails;
  }
  public void setErrorDetails(ErrorDetails errorDetails) {
    this.errorDetails = errorDetails;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LockInformation lockInformation = (LockInformation) o;

    return true && Objects.equals(lockedByUser, lockInformation.lockedByUser) &&
        Objects.equals(lockedByApp, lockInformation.lockedByApp) &&
        Objects.equals(lockedUntilDateTime, lockInformation.lockedUntilDateTime) &&
        Objects.equals(lockDurationInSeconds, lockInformation.lockDurationInSeconds) &&
        Objects.equals(lockType, lockInformation.lockType) &&
        Objects.equals(useScratchPad, lockInformation.useScratchPad) &&
        Objects.equals(lockToken, lockInformation.lockToken) &&
        Objects.equals(errorDetails, lockInformation.errorDetails)
    ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lockedByUser, lockedByApp, lockedUntilDateTime, lockDurationInSeconds, lockType, useScratchPad, lockToken, errorDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LockInformation {\n");
    
    sb.append("    lockedByUser: ").append(toIndentedString(lockedByUser)).append("\n");
    sb.append("    lockedByApp: ").append(toIndentedString(lockedByApp)).append("\n");
    sb.append("    lockedUntilDateTime: ").append(toIndentedString(lockedUntilDateTime)).append("\n");
    sb.append("    lockDurationInSeconds: ").append(toIndentedString(lockDurationInSeconds)).append("\n");
    sb.append("    lockType: ").append(toIndentedString(lockType)).append("\n");
    sb.append("    useScratchPad: ").append(toIndentedString(useScratchPad)).append("\n");
    sb.append("    lockToken: ").append(toIndentedString(lockToken)).append("\n");
    sb.append("    errorDetails: ").append(toIndentedString(errorDetails)).append("\n");
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

