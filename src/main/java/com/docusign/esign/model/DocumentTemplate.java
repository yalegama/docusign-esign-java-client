package com.docusign.esign.model;

import java.util.Objects;
import java.util.Arrays;
import com.docusign.esign.model.ErrorDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * DocumentTemplate.
 *
 */

public class DocumentTemplate {
  @JsonProperty("documentEndPage")
  private String documentEndPage = null;

  @JsonProperty("documentId")
  private String documentId = null;

  @JsonProperty("documentStartPage")
  private String documentStartPage = null;

  @JsonProperty("errorDetails")
  private ErrorDetails errorDetails = null;

  @JsonProperty("templateId")
  private String templateId = null;


  /**
   * documentEndPage.
   *
   * @return DocumentTemplate
   **/
  public DocumentTemplate documentEndPage(String documentEndPage) {
    this.documentEndPage = documentEndPage;
    return this;
  }

  /**
   * .
   * @return documentEndPage
   **/
  @ApiModelProperty(value = "")
  public String getDocumentEndPage() {
    return documentEndPage;
  }

  /**
   * setDocumentEndPage.
   **/
  public void setDocumentEndPage(String documentEndPage) {
    this.documentEndPage = documentEndPage;
  }


  /**
   * documentId.
   *
   * @return DocumentTemplate
   **/
  public DocumentTemplate documentId(String documentId) {
    this.documentId = documentId;
    return this;
  }

  /**
   * Specifies the document ID number that the tab is placed on. This must refer to an existing Document's ID attribute..
   * @return documentId
   **/
  @ApiModelProperty(value = "Specifies the document ID number that the tab is placed on. This must refer to an existing Document's ID attribute.")
  public String getDocumentId() {
    return documentId;
  }

  /**
   * setDocumentId.
   **/
  public void setDocumentId(String documentId) {
    this.documentId = documentId;
  }


  /**
   * documentStartPage.
   *
   * @return DocumentTemplate
   **/
  public DocumentTemplate documentStartPage(String documentStartPage) {
    this.documentStartPage = documentStartPage;
    return this;
  }

  /**
   * .
   * @return documentStartPage
   **/
  @ApiModelProperty(value = "")
  public String getDocumentStartPage() {
    return documentStartPage;
  }

  /**
   * setDocumentStartPage.
   **/
  public void setDocumentStartPage(String documentStartPage) {
    this.documentStartPage = documentStartPage;
  }


  /**
   * errorDetails.
   *
   * @return DocumentTemplate
   **/
  public DocumentTemplate errorDetails(ErrorDetails errorDetails) {
    this.errorDetails = errorDetails;
    return this;
  }

  /**
   * This object describes errors that occur. It is only valid for responses and ignored in requests..
   * @return errorDetails
   **/
  @ApiModelProperty(value = "This object describes errors that occur. It is only valid for responses and ignored in requests.")
  public ErrorDetails getErrorDetails() {
    return errorDetails;
  }

  /**
   * setErrorDetails.
   **/
  public void setErrorDetails(ErrorDetails errorDetails) {
    this.errorDetails = errorDetails;
  }


  /**
   * templateId.
   *
   * @return DocumentTemplate
   **/
  public DocumentTemplate templateId(String templateId) {
    this.templateId = templateId;
    return this;
  }

  /**
   * The unique identifier of the template. If this is not provided, DocuSign will generate a value. .
   * @return templateId
   **/
  @ApiModelProperty(value = "The unique identifier of the template. If this is not provided, DocuSign will generate a value. ")
  public String getTemplateId() {
    return templateId;
  }

  /**
   * setTemplateId.
   **/
  public void setTemplateId(String templateId) {
    this.templateId = templateId;
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
    DocumentTemplate documentTemplate = (DocumentTemplate) o;
    return Objects.equals(this.documentEndPage, documentTemplate.documentEndPage) &&
        Objects.equals(this.documentId, documentTemplate.documentId) &&
        Objects.equals(this.documentStartPage, documentTemplate.documentStartPage) &&
        Objects.equals(this.errorDetails, documentTemplate.errorDetails) &&
        Objects.equals(this.templateId, documentTemplate.templateId);
  }

  /**
   * Returns the HashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(documentEndPage, documentId, documentStartPage, errorDetails, templateId);
  }


  /**
   * Converts the given object to string.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentTemplate {\n");
    
    sb.append("    documentEndPage: ").append(toIndentedString(documentEndPage)).append("\n");
    sb.append("    documentId: ").append(toIndentedString(documentId)).append("\n");
    sb.append("    documentStartPage: ").append(toIndentedString(documentStartPage)).append("\n");
    sb.append("    errorDetails: ").append(toIndentedString(errorDetails)).append("\n");
    sb.append("    templateId: ").append(toIndentedString(templateId)).append("\n");
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

