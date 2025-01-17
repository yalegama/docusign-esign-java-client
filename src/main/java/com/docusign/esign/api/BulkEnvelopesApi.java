
package com.docusign.esign.api;

import javax.ws.rs.core.GenericType;

import com.docusign.esign.client.ApiException;
import com.docusign.esign.client.ApiClient;
import com.docusign.esign.client.Configuration;
import com.docusign.esign.model.*;
import com.docusign.esign.client.Pair;
import com.docusign.esign.client.ApiResponse;




/**
 * BulkEnvelopesApi class.
 *
 **/
public class BulkEnvelopesApi {
  private ApiClient apiClient;

 /**
  * BulkEnvelopesApi.
  *
  **/
  public BulkEnvelopesApi() {
    this(Configuration.getDefaultApiClient());
  }

 /**
  * BulkEnvelopesApi.
  *
  **/
  public BulkEnvelopesApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

 /**
  * getApiClient Method.
  *
  * @return ApiClient
  **/
  public ApiClient getApiClient() {
    return apiClient;
  }

 /**
  * setApiClient Method.
  *
  **/
  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }


  /**
   * Creates a new bulk send list.
   * This method creates a bulk send list that you can use to send an envelope to up to 1,000 recipients at once.  ### Related topics  - [How to bulk send envelopes](/docs/esign-rest-api/how-to/bulk-send-envelopes/)  ### Errors  | Error code                                              | Description                                                                                                                                                                                                                                                                              | | :------------------------------------------------------ | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | | BULK_SEND_MAX_COPIES_EXCEEDED                           | A bulk sending list cannot specify more than XXX copies in the mailing list. Call the settings API endpoint to find the maximum number of copies in a batch allowed for your account. In almost all cases, the default limit is 1000.                                                    | | BULK_SEND_RECIPIENT_IDS_MUST_BE_UNIQUE                  | No two recipientIds can be same within a bulkCopy. Same restriction as a regular envelope applies. Specify unique recipient IDs for each recipient within a bulkCopy (model for envelope in mailing list).                                                                               | | BULK_SEND_RECIPIENT_ID_REQUIRED                         | If no RoleName is present, recipientID is required in mailing list&#39;s bulkCopy. Add a roleName (that coalesces with template/envelope) or a recipientID.                                                                                                                                  | | BULK_SEND_RECIPIENT_NAME_REQUIRED                       | Recipient {0} has no name. Specify a name for the recipient.                                                                                                                                                                                                                             | | BULK_SEND_EMAIL_ADDRESS_REQUIRED_FOR_EMAIL_RECIPIENT    | Recipient {0} is an email recipient with no email address. Specify an email for the email recipient.                                                                                                                                                                                     | | BULK_SEND_FAX_NUMBER_REQUIRED_FOR_FAX_RECIPIENT         | Recipient {0} is a fax recipient with no fax number. Specify a fax number for the fax recipient.                                                                                                                                                                                         | | BULK_SEND_FAX_NUMBER_NOT_VALID                          | Recipient {0} specifies fax number {1}, which is not valid. Specify a valid fax number for the fax recipient.                                                                                                                                                                            | | BULK_SEND_EMAIL_ADDRESS_NOT_VALID                       | Recipient {0} specifies email address {1}, which is not a valid email address.  Specify a valid email address for the recipient.                                                                                                                                                         | | BULK_SEND_PHONE_NUMBER_REQURED_FOR_SMS_AUTH             | Recipient {0} specifies SMS auth, but no number was provided. Specify a phone number for the SMS auth recipient.                                                                                                                                                                         | | BULK_SEND_PHONE_NUMBER_INVALID_FOR_SMS_AUTH             | Recipient {0} specifies phone number {1} for SMS auth, which is not valid. Specify a valid phone number for the SMS auth recipient.                                                                                                                                                      | | BULK_SEND_ROLE_NAMES_MUST_BE_UNIQUE                     | Recipient role names cannot be duplicated; role {duplicateRecipientRole} appears multiple times. Use unique roleNames for recipients.                                                                                                                                                    | | BULK_SEND_CANNOT_USE_BOTH_ROLE_AND_ID_ON_SAME_RECIPIENT | Recipients cannot have both ID and Role; {0} has both. Specify a roleName or recipientId, but not both for the same recipient.                                                                                                                                                           | | BULK_SEND_CANNOT_USE_BOTH_ROLE_AND_ID_IN_SAME_LIST      | Cannot use both recipient role and ID in the same list. Specify a roleName or recipientId, but not both in the same list.                                                                                                                                                                | | BULK_SEND_INVALID_ID_CHECK_CONFIGURATION                | Recipient {0} specified SMS authentication, but no SMS auth settings were provided. Provide an SMS auth setting (proper ID configuration) if SMS auth is specified.                                                                                                                      | | BULK_SEND_INVALID_SBS_INPUT_CONFIGURATION               | Recipient {0} has more than one signature provider specified. Or signingProviderName is not specified. Or Signature provider : {0} is either unknown or not an available pen for this account. One or more SBS configuration is missing or invalid. The error details provide specifics. | | BULK_SEND_TAB_LABELS_MUST_BE_UNIQUE                     | Tab label {0} is duplicated. Needs to be unique. Use a unique tab label.                                                                                                                                                                                                                 | | BULK_SEND_TAB_LABEL_REQUIRED                            | Tab label is required. Specify a tab label.                                                                                                                                                                                                                                              | | BULK_SEND_TAB_VALUE_REQUIRED                            | Tab Label value is required. Specify a value for the tab label.                                                                                                                                                                                                                          | | BULK_SEND_ENVELOPE_CUSTOM_FIELD_NAME_MUST_BE_UNIQUE     | Custom fields must have distinct names. The field {0} appears more than once in a copy. Use unique names for custom fields.                                                                                                                                                              | | BULK_SEND_ENVELOPE_CUSTOM_FIELD_NAME_REQUIRED           | All custom fields must have names. Specify a name for the custom field.                                                                                                                                                                                                                  | | BULK_SEND_ENVELOPE_CUSTOM_FIELD_VALUE_REQUIRED          | Custom field {0} has no value. A custom field can have an empty value, but it cannot have a null value. Specify a value for the custom field.                                                                                                                                            |
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendingList  (optional)
   * @return BulkSendingList
   * @throws ApiException if fails to make API call
   */
  public BulkSendingList createBulkSendList(String accountId, BulkSendingList bulkSendingList) throws ApiException {
    ApiResponse<BulkSendingList> localVarResponse = createBulkSendListWithHttpInfo(accountId, bulkSendingList);
    return localVarResponse.getData();
  }

  /**
   * Creates a new bulk send list
   * This method creates a bulk send list that you can use to send an envelope to up to 1,000 recipients at once.  ### Related topics  - [How to bulk send envelopes](/docs/esign-rest-api/how-to/bulk-send-envelopes/)  ### Errors  | Error code                                              | Description                                                                                                                                                                                                                                                                              | | :------------------------------------------------------ | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | | BULK_SEND_MAX_COPIES_EXCEEDED                           | A bulk sending list cannot specify more than XXX copies in the mailing list. Call the settings API endpoint to find the maximum number of copies in a batch allowed for your account. In almost all cases, the default limit is 1000.                                                    | | BULK_SEND_RECIPIENT_IDS_MUST_BE_UNIQUE                  | No two recipientIds can be same within a bulkCopy. Same restriction as a regular envelope applies. Specify unique recipient IDs for each recipient within a bulkCopy (model for envelope in mailing list).                                                                               | | BULK_SEND_RECIPIENT_ID_REQUIRED                         | If no RoleName is present, recipientID is required in mailing list&#39;s bulkCopy. Add a roleName (that coalesces with template/envelope) or a recipientID.                                                                                                                                  | | BULK_SEND_RECIPIENT_NAME_REQUIRED                       | Recipient {0} has no name. Specify a name for the recipient.                                                                                                                                                                                                                             | | BULK_SEND_EMAIL_ADDRESS_REQUIRED_FOR_EMAIL_RECIPIENT    | Recipient {0} is an email recipient with no email address. Specify an email for the email recipient.                                                                                                                                                                                     | | BULK_SEND_FAX_NUMBER_REQUIRED_FOR_FAX_RECIPIENT         | Recipient {0} is a fax recipient with no fax number. Specify a fax number for the fax recipient.                                                                                                                                                                                         | | BULK_SEND_FAX_NUMBER_NOT_VALID                          | Recipient {0} specifies fax number {1}, which is not valid. Specify a valid fax number for the fax recipient.                                                                                                                                                                            | | BULK_SEND_EMAIL_ADDRESS_NOT_VALID                       | Recipient {0} specifies email address {1}, which is not a valid email address.  Specify a valid email address for the recipient.                                                                                                                                                         | | BULK_SEND_PHONE_NUMBER_REQURED_FOR_SMS_AUTH             | Recipient {0} specifies SMS auth, but no number was provided. Specify a phone number for the SMS auth recipient.                                                                                                                                                                         | | BULK_SEND_PHONE_NUMBER_INVALID_FOR_SMS_AUTH             | Recipient {0} specifies phone number {1} for SMS auth, which is not valid. Specify a valid phone number for the SMS auth recipient.                                                                                                                                                      | | BULK_SEND_ROLE_NAMES_MUST_BE_UNIQUE                     | Recipient role names cannot be duplicated; role {duplicateRecipientRole} appears multiple times. Use unique roleNames for recipients.                                                                                                                                                    | | BULK_SEND_CANNOT_USE_BOTH_ROLE_AND_ID_ON_SAME_RECIPIENT | Recipients cannot have both ID and Role; {0} has both. Specify a roleName or recipientId, but not both for the same recipient.                                                                                                                                                           | | BULK_SEND_CANNOT_USE_BOTH_ROLE_AND_ID_IN_SAME_LIST      | Cannot use both recipient role and ID in the same list. Specify a roleName or recipientId, but not both in the same list.                                                                                                                                                                | | BULK_SEND_INVALID_ID_CHECK_CONFIGURATION                | Recipient {0} specified SMS authentication, but no SMS auth settings were provided. Provide an SMS auth setting (proper ID configuration) if SMS auth is specified.                                                                                                                      | | BULK_SEND_INVALID_SBS_INPUT_CONFIGURATION               | Recipient {0} has more than one signature provider specified. Or signingProviderName is not specified. Or Signature provider : {0} is either unknown or not an available pen for this account. One or more SBS configuration is missing or invalid. The error details provide specifics. | | BULK_SEND_TAB_LABELS_MUST_BE_UNIQUE                     | Tab label {0} is duplicated. Needs to be unique. Use a unique tab label.                                                                                                                                                                                                                 | | BULK_SEND_TAB_LABEL_REQUIRED                            | Tab label is required. Specify a tab label.                                                                                                                                                                                                                                              | | BULK_SEND_TAB_VALUE_REQUIRED                            | Tab Label value is required. Specify a value for the tab label.                                                                                                                                                                                                                          | | BULK_SEND_ENVELOPE_CUSTOM_FIELD_NAME_MUST_BE_UNIQUE     | Custom fields must have distinct names. The field {0} appears more than once in a copy. Use unique names for custom fields.                                                                                                                                                              | | BULK_SEND_ENVELOPE_CUSTOM_FIELD_NAME_REQUIRED           | All custom fields must have names. Specify a name for the custom field.                                                                                                                                                                                                                  | | BULK_SEND_ENVELOPE_CUSTOM_FIELD_VALUE_REQUIRED          | Custom field {0} has no value. A custom field can have an empty value, but it cannot have a null value. Specify a value for the custom field.                                                                                                                                            |
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendingList  (optional)
   * @return BulkSendingList
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BulkSendingList > createBulkSendListWithHttpInfo(String accountId, BulkSendingList bulkSendingList) throws ApiException {
    Object localVarPostBody = bulkSendingList;
    
    // verify the required parameter 'accountId' is set
    if (accountId == null) {
      throw new ApiException(400, "Missing the required parameter 'accountId' when calling createBulkSendList");
    }
    
    // create path and map variables
    String localVarPath = "/v2.1/accounts/{accountId}/bulk_send_lists"
      .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.List<Pair> localVarCollectionQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();

    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "docusignAccessCode" };
    
    GenericType<BulkSendingList> localVarReturnType = new GenericType<BulkSendingList>() {};
    BulkSendingList localVarResponse = apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    return new ApiResponse<BulkSendingList>(apiClient.getStatusCode(), apiClient.getResponseHeaders(), localVarResponse);
  }

  /**
   * Uses the specified bulk send list to send the envelope specified in the payload.
   * This method initiates the bulk send process. It generates a bulk send request based on an [existing bulk send list][create_list] and an envelope or template.  Consider using the [BulkSend::createBulkSendTestRequest][create_test] method to test your bulk send list for compatibility with the envelope or template that you want to send first. To learn about the complete bulk send flow, see the [Bulk Send overview][BulkSendOverview].  If the envelopes were successfully queued for asynchronous processing, the response contains a &#x60;batchId&#x60; that you can use to get the status of the batch. If a failure occurs, the API returns an error message.  **Note:** Partial success or failure generally does not occur. Only the entire batch is queued for asynchronous processing.  ### Related topics  - [How to bulk send envelopes](/docs/esign-rest-api/how-to/bulk-send-envelopes/)   ### Errors  This method returns the following errors:  | Error code                                                 | Description                                                                                                                                                                                                                                                                                            | | :--------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | | BULK_SEND_ENVELOPE_NOT_IN_SENDABLE_STATE                   | Envelope {0} is not in a sendable state. The envelope is not complete. Make sure it has a sendable status, such as &#x60;created&#x60;.                                                                                                                                                                          | | BULK_SEND_ENVELOPE_LIST_CONTAINS_NO_COPIES                 | Cannot send an envelope with a bulk sending list which contains no copies.  The list you&#39;re trying to bulk send is empty. Make sure the bulk sending list you&#39;re using contains recipients.                                                                                                            | | BULK_SEND_ENVELOPE_LIST_CONTAINS_TOO_MANY_COPIES           | Bulk sending list contains more than {0} copies. The list you&#39;re trying to bulk send will cause your account to exceed the 1,000-copy limit imposed for all accounts. Try sending two or more separate lists.                                                                                          | | BULK_SEND_ENVELOPE_CANNOT_BE_NULL                          | Cannot send a bulk list without an envelope. Specify the envelope ID or template ID for the envelope you want to bulk send.                                                                                                                                                                            | | BULK_SEND_BLOB_STORE_ERROR                                 | Could not save copy of bulk sending list. An error writing to the database occurred. Try again. If the error persists, contact DocuSign Support.                                                                                                                                                       | | BULK_SEND_ACCOUNT_HAS_TOO_MANY_QUEUED_ENVELOPES            | Cannot send this bulk sending list because doing so would exceed the maximum of {maxCopies} in-flight envelopes. This account currently has {unprocessedEnvelopes} envelopes waiting to be processed. Please try again later.\&quot; .Try again later, or contact DocuSign Support to request a higher tier. | | BULK_SEND_ENVELOPE_NOT_FOUND                               | Envelope {envelopeOrTemplateId} does not exist or you do not have permission to access it. The envelopeId or templateId specified could not be found. Specify a valid value.                                                                                                                           | | BULK_SEND_LIST_NOT_FOUND                                   | Bulk Sending list {listId} does not exist or you do not have permission to access it. The mailingListId specified could not be found. Specify a valid value.                                                                                                                                           | | BULK_SEND_ENVELOPE_HAS_NO_RECIPIENTS                       | Bulk sending copy contains recipients, but the specified envelope does not. The recipients on the envelope and the bulk send list do not match. Make sure the envelope and list are compatible for sending.                                                                                            | | BULK_SEND_RECIPIENT_ID_DOES_NOT_EXIST_IN_ENVELOPE          | Recipient {0} does not exist in the envelope. Add the missing recipient to the envelope.                                                                                                                                                                                                               | | BULK_SEND_RECIPIENT_ID_DOES_NOT_MATCH                      | Recipient ID {envelopeMember.ID} does not match. Make sure the recipient information in the list and the envelope match up.                                                                                                                                                                            | | BULK_SEND_ENVELOPE_HAS_BULK_RECIPIENT                      | Recipient {0} is a bulk recipient.  This is not supported. No legacy &#39;bulk recipient&#39; allowed. In v2.1 of the eSignature API, you must use a bulk send list instead of a bulk recipient. See the API documentation for details.                                                                        | | BULK_SEND_RECIPIENT_ROLE_DOES_NOT_MATCH                    | Recipient Role {envelopeMember.RoleName} does not match. Make sure the recipient information in the list and the envelope is compatible.                                                                                                                                                               | | BULK_SEND_DUPLICATE_RECIPIENT_DETECTED                     | Duplicate recipients ({0}) not allowed, unless recipients have unique routing order specified on envelope.                                                                                                                                                                                             | | BULK_SEND_ENVELOPE_HAS_NO_TABS                             | Bulk sending copy contains tabs, but the specified envelope does not. List and envelope tabs cannot be coalesced. Make sure they are compatible for sending.                                                                                                                                           | | BULK_SEND_TAB_LABEL_DOES_NOT_EXIST_IN_ENVELOPE             | Tab with label {0} does not exist in envelope. Add the tab label to the envelope, remove the label from the list, or make sure you&#39;re specifying the correct list and envelope.                                                                                                                        | | BULK_SEND_TAB_DOES_NOT_MATCH                               | Tab {0} does not match {0} in envelope. A tab exists on the list that does not match or is missing on the envelope. Make sure the tabs on the list and the envelope match.                                                                                                                             | | BULK_SEND_ENVELOPE_HAS_NO_ENVELOPE_CUSTOM_FIELDS           | Bulk sending copy contains custom fields, but the specified envelope does not. There are custom fields on the list that the envelope does not have. Make sure that any custom fields on the list and the envelope match.                                                                               | | BULK_SEND_ENVELOPE_CUSTOM_FIELD_DOES_NOT_EXIST_IN_ENVELOPE | Custom field {0} does not exist in the envelope. Either add the custom field on the list to the envelope, remove the custom field from the list, or make sure you&#39;re specifying the correct list and envelope.                                                                                         | | BULK_SEND_ENVELOPE_CUSTOM_FIELD_NAME_DOES_NOT_MATCH        | Custom field names must match. {0} and {1} do not match. The custom field names on the list and the envelope do not match. Use identical names for both.                                                                                                                                               |  [create_list]:      /docs/esign-rest-api/reference/bulkenvelopes/bulksend/createbulksendlist/ [create_test]:      /docs/esign-rest-api/reference/bulkenvelopes/bulksend/createbulksendtestrequest/ [BulkSendOverview]: /docs/esign-rest-api/reference/bulkenvelopes/bulksend/  
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendListId  (required)
   * @param bulkSendRequest  (optional)
   * @return BulkSendResponse
   * @throws ApiException if fails to make API call
   */
  public BulkSendResponse createBulkSendRequest(String accountId, String bulkSendListId, BulkSendRequest bulkSendRequest) throws ApiException {
    ApiResponse<BulkSendResponse> localVarResponse = createBulkSendRequestWithHttpInfo(accountId, bulkSendListId, bulkSendRequest);
    return localVarResponse.getData();
  }

  /**
   * Uses the specified bulk send list to send the envelope specified in the payload
   * This method initiates the bulk send process. It generates a bulk send request based on an [existing bulk send list][create_list] and an envelope or template.  Consider using the [BulkSend::createBulkSendTestRequest][create_test] method to test your bulk send list for compatibility with the envelope or template that you want to send first. To learn about the complete bulk send flow, see the [Bulk Send overview][BulkSendOverview].  If the envelopes were successfully queued for asynchronous processing, the response contains a &#x60;batchId&#x60; that you can use to get the status of the batch. If a failure occurs, the API returns an error message.  **Note:** Partial success or failure generally does not occur. Only the entire batch is queued for asynchronous processing.  ### Related topics  - [How to bulk send envelopes](/docs/esign-rest-api/how-to/bulk-send-envelopes/)   ### Errors  This method returns the following errors:  | Error code                                                 | Description                                                                                                                                                                                                                                                                                            | | :--------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | | BULK_SEND_ENVELOPE_NOT_IN_SENDABLE_STATE                   | Envelope {0} is not in a sendable state. The envelope is not complete. Make sure it has a sendable status, such as &#x60;created&#x60;.                                                                                                                                                                          | | BULK_SEND_ENVELOPE_LIST_CONTAINS_NO_COPIES                 | Cannot send an envelope with a bulk sending list which contains no copies.  The list you&#39;re trying to bulk send is empty. Make sure the bulk sending list you&#39;re using contains recipients.                                                                                                            | | BULK_SEND_ENVELOPE_LIST_CONTAINS_TOO_MANY_COPIES           | Bulk sending list contains more than {0} copies. The list you&#39;re trying to bulk send will cause your account to exceed the 1,000-copy limit imposed for all accounts. Try sending two or more separate lists.                                                                                          | | BULK_SEND_ENVELOPE_CANNOT_BE_NULL                          | Cannot send a bulk list without an envelope. Specify the envelope ID or template ID for the envelope you want to bulk send.                                                                                                                                                                            | | BULK_SEND_BLOB_STORE_ERROR                                 | Could not save copy of bulk sending list. An error writing to the database occurred. Try again. If the error persists, contact DocuSign Support.                                                                                                                                                       | | BULK_SEND_ACCOUNT_HAS_TOO_MANY_QUEUED_ENVELOPES            | Cannot send this bulk sending list because doing so would exceed the maximum of {maxCopies} in-flight envelopes. This account currently has {unprocessedEnvelopes} envelopes waiting to be processed. Please try again later.\&quot; .Try again later, or contact DocuSign Support to request a higher tier. | | BULK_SEND_ENVELOPE_NOT_FOUND                               | Envelope {envelopeOrTemplateId} does not exist or you do not have permission to access it. The envelopeId or templateId specified could not be found. Specify a valid value.                                                                                                                           | | BULK_SEND_LIST_NOT_FOUND                                   | Bulk Sending list {listId} does not exist or you do not have permission to access it. The mailingListId specified could not be found. Specify a valid value.                                                                                                                                           | | BULK_SEND_ENVELOPE_HAS_NO_RECIPIENTS                       | Bulk sending copy contains recipients, but the specified envelope does not. The recipients on the envelope and the bulk send list do not match. Make sure the envelope and list are compatible for sending.                                                                                            | | BULK_SEND_RECIPIENT_ID_DOES_NOT_EXIST_IN_ENVELOPE          | Recipient {0} does not exist in the envelope. Add the missing recipient to the envelope.                                                                                                                                                                                                               | | BULK_SEND_RECIPIENT_ID_DOES_NOT_MATCH                      | Recipient ID {envelopeMember.ID} does not match. Make sure the recipient information in the list and the envelope match up.                                                                                                                                                                            | | BULK_SEND_ENVELOPE_HAS_BULK_RECIPIENT                      | Recipient {0} is a bulk recipient.  This is not supported. No legacy &#39;bulk recipient&#39; allowed. In v2.1 of the eSignature API, you must use a bulk send list instead of a bulk recipient. See the API documentation for details.                                                                        | | BULK_SEND_RECIPIENT_ROLE_DOES_NOT_MATCH                    | Recipient Role {envelopeMember.RoleName} does not match. Make sure the recipient information in the list and the envelope is compatible.                                                                                                                                                               | | BULK_SEND_DUPLICATE_RECIPIENT_DETECTED                     | Duplicate recipients ({0}) not allowed, unless recipients have unique routing order specified on envelope.                                                                                                                                                                                             | | BULK_SEND_ENVELOPE_HAS_NO_TABS                             | Bulk sending copy contains tabs, but the specified envelope does not. List and envelope tabs cannot be coalesced. Make sure they are compatible for sending.                                                                                                                                           | | BULK_SEND_TAB_LABEL_DOES_NOT_EXIST_IN_ENVELOPE             | Tab with label {0} does not exist in envelope. Add the tab label to the envelope, remove the label from the list, or make sure you&#39;re specifying the correct list and envelope.                                                                                                                        | | BULK_SEND_TAB_DOES_NOT_MATCH                               | Tab {0} does not match {0} in envelope. A tab exists on the list that does not match or is missing on the envelope. Make sure the tabs on the list and the envelope match.                                                                                                                             | | BULK_SEND_ENVELOPE_HAS_NO_ENVELOPE_CUSTOM_FIELDS           | Bulk sending copy contains custom fields, but the specified envelope does not. There are custom fields on the list that the envelope does not have. Make sure that any custom fields on the list and the envelope match.                                                                               | | BULK_SEND_ENVELOPE_CUSTOM_FIELD_DOES_NOT_EXIST_IN_ENVELOPE | Custom field {0} does not exist in the envelope. Either add the custom field on the list to the envelope, remove the custom field from the list, or make sure you&#39;re specifying the correct list and envelope.                                                                                         | | BULK_SEND_ENVELOPE_CUSTOM_FIELD_NAME_DOES_NOT_MATCH        | Custom field names must match. {0} and {1} do not match. The custom field names on the list and the envelope do not match. Use identical names for both.                                                                                                                                               |  [create_list]:      /docs/esign-rest-api/reference/bulkenvelopes/bulksend/createbulksendlist/ [create_test]:      /docs/esign-rest-api/reference/bulkenvelopes/bulksend/createbulksendtestrequest/ [BulkSendOverview]: /docs/esign-rest-api/reference/bulkenvelopes/bulksend/  
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendListId  (required)
   * @param bulkSendRequest  (optional)
   * @return BulkSendResponse
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BulkSendResponse > createBulkSendRequestWithHttpInfo(String accountId, String bulkSendListId, BulkSendRequest bulkSendRequest) throws ApiException {
    Object localVarPostBody = bulkSendRequest;
    
    // verify the required parameter 'accountId' is set
    if (accountId == null) {
      throw new ApiException(400, "Missing the required parameter 'accountId' when calling createBulkSendRequest");
    }
    
    // verify the required parameter 'bulkSendListId' is set
    if (bulkSendListId == null) {
      throw new ApiException(400, "Missing the required parameter 'bulkSendListId' when calling createBulkSendRequest");
    }
    
    // create path and map variables
    String localVarPath = "/v2.1/accounts/{accountId}/bulk_send_lists/{bulkSendListId}/send"
      .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId.toString()))
      .replaceAll("\\{" + "bulkSendListId" + "\\}", apiClient.escapeString(bulkSendListId.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.List<Pair> localVarCollectionQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();

    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "docusignAccessCode" };
    
    GenericType<BulkSendResponse> localVarReturnType = new GenericType<BulkSendResponse>() {};
    BulkSendResponse localVarResponse = apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    return new ApiResponse<BulkSendResponse>(apiClient.getStatusCode(), apiClient.getResponseHeaders(), localVarResponse);
  }

  /**
   * Tests whether the specified bulk sending list can be used to send an envelope.
   * This method tests a bulk send list for compatibility with the envelope or template that you want to send. For example, a template that has three roles is not compatible with a bulk send list that has only two recipients. For this reason, you might want to test compatibility first.  A successful test result returns &#x60;true&#x60; for the &#x60;canBeSent&#x60; property. An unsuccessful test returns a JSON response that contains information about the errors that occurred.  If the test is successful, you can then send the envelope or template by using the [BulkSend::createBulkSendRequest][BulkSendRequest] method.  ## Envelope Compatibility Checks  This section describes the envelope compatibility checks that the system performs.  **Top-Level Issues**  - Envelopes must be in a sendable state. - The bulk send list must contain at least one copy (instance of an envelope), and no more than the maximum number of copies allowed for the account. - The envelope must not be null and must be visible to the current user. - The account cannot have more queued envelopes than the maximum number configured for the account. - The bulk send list must exist.  **Recipients**  - The envelope must have recipients. - If you are using an envelope, all of the recipients defined in the bulk send list must have corresponding recipient IDs in the envelope definition. If you are using a template, you must either match the recipient IDs or role IDs. - The envelope cannot contain a bulk recipient (an artifact of the legacy version of DocuSign&#39;s bulk send   functionality).  **Recipient Tabs**  - Every &#x60;recipient ID, tab label&#x60; pair in the bulk send list must correspond to a tab in the envelope.  **Custom Fields**  - Each envelope-level custom field in the bulk send list must correspond to the name of a &#x60;customField&#x60; in the   envelope definition. You do not have to match the recipient-level custom fields.  [BulkSendRequest]:  /docs/esign-rest-api/reference/bulkenvelopes/bulksend/createbulksendrequest/   
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendListId  (required)
   * @param bulkSendRequest  (optional)
   * @return BulkSendTestResponse
   * @throws ApiException if fails to make API call
   */
  public BulkSendTestResponse createBulkSendTestRequest(String accountId, String bulkSendListId, BulkSendRequest bulkSendRequest) throws ApiException {
    ApiResponse<BulkSendTestResponse> localVarResponse = createBulkSendTestRequestWithHttpInfo(accountId, bulkSendListId, bulkSendRequest);
    return localVarResponse.getData();
  }

  /**
   * Tests whether the specified bulk sending list can be used to send an envelope
   * This method tests a bulk send list for compatibility with the envelope or template that you want to send. For example, a template that has three roles is not compatible with a bulk send list that has only two recipients. For this reason, you might want to test compatibility first.  A successful test result returns &#x60;true&#x60; for the &#x60;canBeSent&#x60; property. An unsuccessful test returns a JSON response that contains information about the errors that occurred.  If the test is successful, you can then send the envelope or template by using the [BulkSend::createBulkSendRequest][BulkSendRequest] method.  ## Envelope Compatibility Checks  This section describes the envelope compatibility checks that the system performs.  **Top-Level Issues**  - Envelopes must be in a sendable state. - The bulk send list must contain at least one copy (instance of an envelope), and no more than the maximum number of copies allowed for the account. - The envelope must not be null and must be visible to the current user. - The account cannot have more queued envelopes than the maximum number configured for the account. - The bulk send list must exist.  **Recipients**  - The envelope must have recipients. - If you are using an envelope, all of the recipients defined in the bulk send list must have corresponding recipient IDs in the envelope definition. If you are using a template, you must either match the recipient IDs or role IDs. - The envelope cannot contain a bulk recipient (an artifact of the legacy version of DocuSign&#39;s bulk send   functionality).  **Recipient Tabs**  - Every &#x60;recipient ID, tab label&#x60; pair in the bulk send list must correspond to a tab in the envelope.  **Custom Fields**  - Each envelope-level custom field in the bulk send list must correspond to the name of a &#x60;customField&#x60; in the   envelope definition. You do not have to match the recipient-level custom fields.  [BulkSendRequest]:  /docs/esign-rest-api/reference/bulkenvelopes/bulksend/createbulksendrequest/   
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendListId  (required)
   * @param bulkSendRequest  (optional)
   * @return BulkSendTestResponse
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BulkSendTestResponse > createBulkSendTestRequestWithHttpInfo(String accountId, String bulkSendListId, BulkSendRequest bulkSendRequest) throws ApiException {
    Object localVarPostBody = bulkSendRequest;
    
    // verify the required parameter 'accountId' is set
    if (accountId == null) {
      throw new ApiException(400, "Missing the required parameter 'accountId' when calling createBulkSendTestRequest");
    }
    
    // verify the required parameter 'bulkSendListId' is set
    if (bulkSendListId == null) {
      throw new ApiException(400, "Missing the required parameter 'bulkSendListId' when calling createBulkSendTestRequest");
    }
    
    // create path and map variables
    String localVarPath = "/v2.1/accounts/{accountId}/bulk_send_lists/{bulkSendListId}/test"
      .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId.toString()))
      .replaceAll("\\{" + "bulkSendListId" + "\\}", apiClient.escapeString(bulkSendListId.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.List<Pair> localVarCollectionQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();

    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "docusignAccessCode" };
    
    GenericType<BulkSendTestResponse> localVarReturnType = new GenericType<BulkSendTestResponse>() {};
    BulkSendTestResponse localVarResponse = apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    return new ApiResponse<BulkSendTestResponse>(apiClient.getStatusCode(), apiClient.getResponseHeaders(), localVarResponse);
  }

  /**
   * Deletes an existing bulk send list.
   * This method deletes a bulk send list.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendListId  (required)
   * @return BulkSendingListSummaries
   * @throws ApiException if fails to make API call
   */
  public BulkSendingListSummaries deleteBulkSendList(String accountId, String bulkSendListId) throws ApiException {
    ApiResponse<BulkSendingListSummaries> localVarResponse = deleteBulkSendListWithHttpInfo(accountId, bulkSendListId);
    return localVarResponse.getData();
  }

  /**
   * Deletes an existing bulk send list
   * This method deletes a bulk send list.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendListId  (required)
   * @return BulkSendingListSummaries
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BulkSendingListSummaries > deleteBulkSendListWithHttpInfo(String accountId, String bulkSendListId) throws ApiException {
    Object localVarPostBody = "{}";
    
    // verify the required parameter 'accountId' is set
    if (accountId == null) {
      throw new ApiException(400, "Missing the required parameter 'accountId' when calling deleteBulkSendList");
    }
    
    // verify the required parameter 'bulkSendListId' is set
    if (bulkSendListId == null) {
      throw new ApiException(400, "Missing the required parameter 'bulkSendListId' when calling deleteBulkSendList");
    }
    
    // create path and map variables
    String localVarPath = "/v2.1/accounts/{accountId}/bulk_send_lists/{bulkSendListId}"
      .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId.toString()))
      .replaceAll("\\{" + "bulkSendListId" + "\\}", apiClient.escapeString(bulkSendListId.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.List<Pair> localVarCollectionQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();

    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "docusignAccessCode" };
    
    GenericType<BulkSendingListSummaries> localVarReturnType = new GenericType<BulkSendingListSummaries>() {};
    BulkSendingListSummaries localVarResponse = apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    return new ApiResponse<BulkSendingListSummaries>(apiClient.getStatusCode(), apiClient.getResponseHeaders(), localVarResponse);
  }
  /// <summary>
  /// Gets envelopes from a specific bulk send batch This method returns a list of envelopes in a specified bulk batch. Use the query parameters to filter and sort the envelopes by different attributes.
  /// </summary>

 /**
  * GetBulkSendBatchEnvelopesOptions Class.
  *
  **/
  public class GetBulkSendBatchEnvelopesOptions
  {
  private String count = null;
  private String include = null;
  private String order = null;
  private String orderBy = null;
  private String searchText = null;
  private String startPosition = null;
  private String status = null;
  
 /**
  * setCount method.
  */
  public void setCount(String count) {
    this.count = count;
  }

 /**
  * getCount method.
  *
  * @return String
  */
  public String getCount() {
    return this.count;
  }
  
 /**
  * setInclude method.
  */
  public void setInclude(String include) {
    this.include = include;
  }

 /**
  * getInclude method.
  *
  * @return String
  */
  public String getInclude() {
    return this.include;
  }
  
 /**
  * setOrder method.
  */
  public void setOrder(String order) {
    this.order = order;
  }

 /**
  * getOrder method.
  *
  * @return String
  */
  public String getOrder() {
    return this.order;
  }
  
 /**
  * setOrderBy method.
  */
  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

 /**
  * getOrderBy method.
  *
  * @return String
  */
  public String getOrderBy() {
    return this.orderBy;
  }
  
 /**
  * setSearchText method.
  */
  public void setSearchText(String searchText) {
    this.searchText = searchText;
  }

 /**
  * getSearchText method.
  *
  * @return String
  */
  public String getSearchText() {
    return this.searchText;
  }
  
 /**
  * setStartPosition method.
  */
  public void setStartPosition(String startPosition) {
    this.startPosition = startPosition;
  }

 /**
  * getStartPosition method.
  *
  * @return String
  */
  public String getStartPosition() {
    return this.startPosition;
  }
  
 /**
  * setStatus method.
  */
  public void setStatus(String status) {
    this.status = status;
  }

 /**
  * getStatus method.
  *
  * @return String
  */
  public String getStatus() {
    return this.status;
  }
  }

   /**
   * Gets envelopes from a specific bulk send batch.
   * This method returns a list of envelopes in a specified bulk batch. Use the query parameters to filter and sort the envelopes by different attributes.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendBatchId  (required)
   * @return EnvelopesInformation
   */ 
  public EnvelopesInformation getBulkSendBatchEnvelopes(String accountId, String bulkSendBatchId) throws ApiException {
    return getBulkSendBatchEnvelopes(accountId, bulkSendBatchId, null);
  }

  /**
   * Gets envelopes from a specific bulk send batch.
   * This method returns a list of envelopes in a specified bulk batch. Use the query parameters to filter and sort the envelopes by different attributes.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendBatchId  (required)
   * @param options for modifying the method behavior.
   * @return EnvelopesInformation
   * @throws ApiException if fails to make API call
   */
  public EnvelopesInformation getBulkSendBatchEnvelopes(String accountId, String bulkSendBatchId, BulkEnvelopesApi.GetBulkSendBatchEnvelopesOptions options) throws ApiException {
    ApiResponse<EnvelopesInformation> localVarResponse = getBulkSendBatchEnvelopesWithHttpInfo(accountId, bulkSendBatchId, options);
    return localVarResponse.getData();
  }

  /**
   * Gets envelopes from a specific bulk send batch
   * This method returns a list of envelopes in a specified bulk batch. Use the query parameters to filter and sort the envelopes by different attributes.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendBatchId  (required)
   * @param options for modifying the method behavior.
   * @return EnvelopesInformation
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<EnvelopesInformation > getBulkSendBatchEnvelopesWithHttpInfo(String accountId, String bulkSendBatchId, BulkEnvelopesApi.GetBulkSendBatchEnvelopesOptions options) throws ApiException {
    Object localVarPostBody = "{}";
    
    // verify the required parameter 'accountId' is set
    if (accountId == null) {
      throw new ApiException(400, "Missing the required parameter 'accountId' when calling getBulkSendBatchEnvelopes");
    }
    
    // verify the required parameter 'bulkSendBatchId' is set
    if (bulkSendBatchId == null) {
      throw new ApiException(400, "Missing the required parameter 'bulkSendBatchId' when calling getBulkSendBatchEnvelopes");
    }
    
    // create path and map variables
    String localVarPath = "/v2.1/accounts/{accountId}/bulk_send_batch/{bulkSendBatchId}/envelopes"
      .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId.toString()))
      .replaceAll("\\{" + "bulkSendBatchId" + "\\}", apiClient.escapeString(bulkSendBatchId.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.List<Pair> localVarCollectionQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();

    if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("count", options.count));
    }if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("include", options.include));
    }if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("order", options.order));
    }if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("order_by", options.orderBy));
    }if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("search_text", options.searchText));
    }if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("start_position", options.startPosition));
    }if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("status", options.status));
    }

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "docusignAccessCode" };
    
    GenericType<EnvelopesInformation> localVarReturnType = new GenericType<EnvelopesInformation>() {};
    EnvelopesInformation localVarResponse = apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    return new ApiResponse<EnvelopesInformation>(apiClient.getStatusCode(), apiClient.getResponseHeaders(), localVarResponse);
  }

  /**
   * Gets a specific bulk send batch status.
   * Gets the general status of a specific bulk send batch such as:  - number of successes - number pending - number of errors  The &#x60;bulkErrors&#x60; property of the response object contains more information about the errors.  ### Related topics  - [How to bulk send envelopes](/docs/esign-rest-api/how-to/bulk-send-envelopes/) 
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendBatchId  (required)
   * @return BulkSendBatchStatus
   * @throws ApiException if fails to make API call
   */
  public BulkSendBatchStatus getBulkSendBatchStatus(String accountId, String bulkSendBatchId) throws ApiException {
    ApiResponse<BulkSendBatchStatus> localVarResponse = getBulkSendBatchStatusWithHttpInfo(accountId, bulkSendBatchId);
    return localVarResponse.getData();
  }

  /**
   * Gets a specific bulk send batch status
   * Gets the general status of a specific bulk send batch such as:  - number of successes - number pending - number of errors  The &#x60;bulkErrors&#x60; property of the response object contains more information about the errors.  ### Related topics  - [How to bulk send envelopes](/docs/esign-rest-api/how-to/bulk-send-envelopes/) 
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendBatchId  (required)
   * @return BulkSendBatchStatus
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BulkSendBatchStatus > getBulkSendBatchStatusWithHttpInfo(String accountId, String bulkSendBatchId) throws ApiException {
    Object localVarPostBody = "{}";
    
    // verify the required parameter 'accountId' is set
    if (accountId == null) {
      throw new ApiException(400, "Missing the required parameter 'accountId' when calling getBulkSendBatchStatus");
    }
    
    // verify the required parameter 'bulkSendBatchId' is set
    if (bulkSendBatchId == null) {
      throw new ApiException(400, "Missing the required parameter 'bulkSendBatchId' when calling getBulkSendBatchStatus");
    }
    
    // create path and map variables
    String localVarPath = "/v2.1/accounts/{accountId}/bulk_send_batch/{bulkSendBatchId}"
      .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId.toString()))
      .replaceAll("\\{" + "bulkSendBatchId" + "\\}", apiClient.escapeString(bulkSendBatchId.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.List<Pair> localVarCollectionQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();

    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "docusignAccessCode" };
    
    GenericType<BulkSendBatchStatus> localVarReturnType = new GenericType<BulkSendBatchStatus>() {};
    BulkSendBatchStatus localVarResponse = apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    return new ApiResponse<BulkSendBatchStatus>(apiClient.getStatusCode(), apiClient.getResponseHeaders(), localVarResponse);
  }
  /// <summary>
  /// Returns a list of bulk send batch satuses initiated by account. Returns a summary of bulk send batches.  Use the &#x60;batch_ids&#x60; query parameter to narrow the list of batches.
  /// </summary>

 /**
  * GetBulkSendBatchesOptions Class.
  *
  **/
  public class GetBulkSendBatchesOptions
  {
  private String batchIds = null;
  private String count = null;
  private String fromDate = null;
  private String searchText = null;
  private String startPosition = null;
  private String status = null;
  private String toDate = null;
  private String userId = null;
  
 /**
  * setBatchIds method.
  */
  public void setBatchIds(String batchIds) {
    this.batchIds = batchIds;
  }

 /**
  * getBatchIds method.
  *
  * @return String
  */
  public String getBatchIds() {
    return this.batchIds;
  }
  
 /**
  * setCount method.
  */
  public void setCount(String count) {
    this.count = count;
  }

 /**
  * getCount method.
  *
  * @return String
  */
  public String getCount() {
    return this.count;
  }
  
 /**
  * setFromDate method.
  */
  public void setFromDate(String fromDate) {
    this.fromDate = fromDate;
  }

 /**
  * getFromDate method.
  *
  * @return String
  */
  public String getFromDate() {
    return this.fromDate;
  }
  
 /**
  * setSearchText method.
  */
  public void setSearchText(String searchText) {
    this.searchText = searchText;
  }

 /**
  * getSearchText method.
  *
  * @return String
  */
  public String getSearchText() {
    return this.searchText;
  }
  
 /**
  * setStartPosition method.
  */
  public void setStartPosition(String startPosition) {
    this.startPosition = startPosition;
  }

 /**
  * getStartPosition method.
  *
  * @return String
  */
  public String getStartPosition() {
    return this.startPosition;
  }
  
 /**
  * setStatus method.
  */
  public void setStatus(String status) {
    this.status = status;
  }

 /**
  * getStatus method.
  *
  * @return String
  */
  public String getStatus() {
    return this.status;
  }
  
 /**
  * setToDate method.
  */
  public void setToDate(String toDate) {
    this.toDate = toDate;
  }

 /**
  * getToDate method.
  *
  * @return String
  */
  public String getToDate() {
    return this.toDate;
  }
  
 /**
  * setUserId method.
  */
  public void setUserId(String userId) {
    this.userId = userId;
  }

 /**
  * getUserId method.
  *
  * @return String
  */
  public String getUserId() {
    return this.userId;
  }
  }

   /**
   * Returns a list of bulk send batch satuses initiated by account..
   * Returns a summary of bulk send batches.  Use the &#x60;batch_ids&#x60; query parameter to narrow the list of batches.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @return BulkSendBatchSummaries
   */ 
  public BulkSendBatchSummaries getBulkSendBatches(String accountId) throws ApiException {
    return getBulkSendBatches(accountId, null);
  }

  /**
   * Returns a list of bulk send batch satuses initiated by account..
   * Returns a summary of bulk send batches.  Use the &#x60;batch_ids&#x60; query parameter to narrow the list of batches.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param options for modifying the method behavior.
   * @return BulkSendBatchSummaries
   * @throws ApiException if fails to make API call
   */
  public BulkSendBatchSummaries getBulkSendBatches(String accountId, BulkEnvelopesApi.GetBulkSendBatchesOptions options) throws ApiException {
    ApiResponse<BulkSendBatchSummaries> localVarResponse = getBulkSendBatchesWithHttpInfo(accountId, options);
    return localVarResponse.getData();
  }

  /**
   * Returns a list of bulk send batch satuses initiated by account.
   * Returns a summary of bulk send batches.  Use the &#x60;batch_ids&#x60; query parameter to narrow the list of batches.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param options for modifying the method behavior.
   * @return BulkSendBatchSummaries
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BulkSendBatchSummaries > getBulkSendBatchesWithHttpInfo(String accountId, BulkEnvelopesApi.GetBulkSendBatchesOptions options) throws ApiException {
    Object localVarPostBody = "{}";
    
    // verify the required parameter 'accountId' is set
    if (accountId == null) {
      throw new ApiException(400, "Missing the required parameter 'accountId' when calling getBulkSendBatches");
    }
    
    // create path and map variables
    String localVarPath = "/v2.1/accounts/{accountId}/bulk_send_batch"
      .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.List<Pair> localVarCollectionQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();

    if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("batch_ids", options.batchIds));
    }if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("count", options.count));
    }if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("from_date", options.fromDate));
    }if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("search_text", options.searchText));
    }if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("start_position", options.startPosition));
    }if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("status", options.status));
    }if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("to_date", options.toDate));
    }if (options != null) {
      localVarQueryParams.addAll(apiClient.parameterToPair("user_id", options.userId));
    }

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "docusignAccessCode" };
    
    GenericType<BulkSendBatchSummaries> localVarReturnType = new GenericType<BulkSendBatchSummaries>() {};
    BulkSendBatchSummaries localVarResponse = apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    return new ApiResponse<BulkSendBatchSummaries>(apiClient.getStatusCode(), apiClient.getResponseHeaders(), localVarResponse);
  }

  /**
   * Gets a specific bulk send list.
   * This method returns all of the details associated with a specific bulk send list that belongs to the current user.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendListId  (required)
   * @return BulkSendingList
   * @throws ApiException if fails to make API call
   */
  public BulkSendingList getBulkSendList(String accountId, String bulkSendListId) throws ApiException {
    ApiResponse<BulkSendingList> localVarResponse = getBulkSendListWithHttpInfo(accountId, bulkSendListId);
    return localVarResponse.getData();
  }

  /**
   * Gets a specific bulk send list
   * This method returns all of the details associated with a specific bulk send list that belongs to the current user.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendListId  (required)
   * @return BulkSendingList
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BulkSendingList > getBulkSendListWithHttpInfo(String accountId, String bulkSendListId) throws ApiException {
    Object localVarPostBody = "{}";
    
    // verify the required parameter 'accountId' is set
    if (accountId == null) {
      throw new ApiException(400, "Missing the required parameter 'accountId' when calling getBulkSendList");
    }
    
    // verify the required parameter 'bulkSendListId' is set
    if (bulkSendListId == null) {
      throw new ApiException(400, "Missing the required parameter 'bulkSendListId' when calling getBulkSendList");
    }
    
    // create path and map variables
    String localVarPath = "/v2.1/accounts/{accountId}/bulk_send_lists/{bulkSendListId}"
      .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId.toString()))
      .replaceAll("\\{" + "bulkSendListId" + "\\}", apiClient.escapeString(bulkSendListId.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.List<Pair> localVarCollectionQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();

    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "docusignAccessCode" };
    
    GenericType<BulkSendingList> localVarReturnType = new GenericType<BulkSendingList>() {};
    BulkSendingList localVarResponse = apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    return new ApiResponse<BulkSendingList>(apiClient.getStatusCode(), apiClient.getResponseHeaders(), localVarResponse);
  }

  /**
   * Lists top-level details for all bulk send lists visible to the current user.
   * This method returns a list of bulk send lists belonging to the current user, as well as basic information about each list.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @return BulkSendingListSummaries
   * @throws ApiException if fails to make API call
   */
  public BulkSendingListSummaries getBulkSendLists(String accountId) throws ApiException {
    ApiResponse<BulkSendingListSummaries> localVarResponse = getBulkSendListsWithHttpInfo(accountId);
    return localVarResponse.getData();
  }

  /**
   * Lists top-level details for all bulk send lists visible to the current user
   * This method returns a list of bulk send lists belonging to the current user, as well as basic information about each list.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @return BulkSendingListSummaries
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BulkSendingListSummaries > getBulkSendListsWithHttpInfo(String accountId) throws ApiException {
    Object localVarPostBody = "{}";
    
    // verify the required parameter 'accountId' is set
    if (accountId == null) {
      throw new ApiException(400, "Missing the required parameter 'accountId' when calling getBulkSendLists");
    }
    
    // create path and map variables
    String localVarPath = "/v2.1/accounts/{accountId}/bulk_send_lists"
      .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.List<Pair> localVarCollectionQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();

    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "docusignAccessCode" };
    
    GenericType<BulkSendingListSummaries> localVarReturnType = new GenericType<BulkSendingListSummaries>() {};
    BulkSendingListSummaries localVarResponse = apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    return new ApiResponse<BulkSendingListSummaries>(apiClient.getStatusCode(), apiClient.getResponseHeaders(), localVarResponse);
  }

  /**
   * Initiate a specific bulk send batch action.
   * 
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendBatchId  (required)
   * @param bulkAction  (required)
   * @param bulkSendBatchActionRequest  (optional)
   * @return BulkSendBatchStatus
   * @throws ApiException if fails to make API call
   */
  public BulkSendBatchStatus updateBulkSendBatchAction(String accountId, String bulkSendBatchId, String bulkAction, BulkSendBatchActionRequest bulkSendBatchActionRequest) throws ApiException {
    ApiResponse<BulkSendBatchStatus> localVarResponse = updateBulkSendBatchActionWithHttpInfo(accountId, bulkSendBatchId, bulkAction, bulkSendBatchActionRequest);
    return localVarResponse.getData();
  }

  /**
   * Initiate a specific bulk send batch action
   * 
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendBatchId  (required)
   * @param bulkAction  (required)
   * @param bulkSendBatchActionRequest  (optional)
   * @return BulkSendBatchStatus
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BulkSendBatchStatus > updateBulkSendBatchActionWithHttpInfo(String accountId, String bulkSendBatchId, String bulkAction, BulkSendBatchActionRequest bulkSendBatchActionRequest) throws ApiException {
    Object localVarPostBody = bulkSendBatchActionRequest;
    
    // verify the required parameter 'accountId' is set
    if (accountId == null) {
      throw new ApiException(400, "Missing the required parameter 'accountId' when calling updateBulkSendBatchAction");
    }
    
    // verify the required parameter 'bulkSendBatchId' is set
    if (bulkSendBatchId == null) {
      throw new ApiException(400, "Missing the required parameter 'bulkSendBatchId' when calling updateBulkSendBatchAction");
    }
    
    // verify the required parameter 'bulkAction' is set
    if (bulkAction == null) {
      throw new ApiException(400, "Missing the required parameter 'bulkAction' when calling updateBulkSendBatchAction");
    }
    
    // create path and map variables
    String localVarPath = "/v2.1/accounts/{accountId}/bulk_send_batch/{bulkSendBatchId}/{bulkAction}"
      .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId.toString()))
      .replaceAll("\\{" + "bulkSendBatchId" + "\\}", apiClient.escapeString(bulkSendBatchId.toString()))
      .replaceAll("\\{" + "bulkAction" + "\\}", apiClient.escapeString(bulkAction.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.List<Pair> localVarCollectionQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();

    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "docusignAccessCode" };
    
    GenericType<BulkSendBatchStatus> localVarReturnType = new GenericType<BulkSendBatchStatus>() {};
    BulkSendBatchStatus localVarResponse = apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    return new ApiResponse<BulkSendBatchStatus>(apiClient.getStatusCode(), apiClient.getResponseHeaders(), localVarResponse);
  }

  /**
   * Put/Update a specific bulk send batch status.
   * Updates a specific bulk send batch status.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendBatchId  (required)
   * @param bulkSendBatchRequest  (optional)
   * @return BulkSendBatchStatus
   * @throws ApiException if fails to make API call
   */
  public BulkSendBatchStatus updateBulkSendBatchStatus(String accountId, String bulkSendBatchId, BulkSendBatchRequest bulkSendBatchRequest) throws ApiException {
    ApiResponse<BulkSendBatchStatus> localVarResponse = updateBulkSendBatchStatusWithHttpInfo(accountId, bulkSendBatchId, bulkSendBatchRequest);
    return localVarResponse.getData();
  }

  /**
   * Put/Update a specific bulk send batch status
   * Updates a specific bulk send batch status.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendBatchId  (required)
   * @param bulkSendBatchRequest  (optional)
   * @return BulkSendBatchStatus
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BulkSendBatchStatus > updateBulkSendBatchStatusWithHttpInfo(String accountId, String bulkSendBatchId, BulkSendBatchRequest bulkSendBatchRequest) throws ApiException {
    Object localVarPostBody = bulkSendBatchRequest;
    
    // verify the required parameter 'accountId' is set
    if (accountId == null) {
      throw new ApiException(400, "Missing the required parameter 'accountId' when calling updateBulkSendBatchStatus");
    }
    
    // verify the required parameter 'bulkSendBatchId' is set
    if (bulkSendBatchId == null) {
      throw new ApiException(400, "Missing the required parameter 'bulkSendBatchId' when calling updateBulkSendBatchStatus");
    }
    
    // create path and map variables
    String localVarPath = "/v2.1/accounts/{accountId}/bulk_send_batch/{bulkSendBatchId}"
      .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId.toString()))
      .replaceAll("\\{" + "bulkSendBatchId" + "\\}", apiClient.escapeString(bulkSendBatchId.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.List<Pair> localVarCollectionQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();

    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "docusignAccessCode" };
    
    GenericType<BulkSendBatchStatus> localVarReturnType = new GenericType<BulkSendBatchStatus>() {};
    BulkSendBatchStatus localVarResponse = apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    return new ApiResponse<BulkSendBatchStatus>(apiClient.getStatusCode(), apiClient.getResponseHeaders(), localVarResponse);
  }

  /**
   * Updates an existing bulk send list.  If send_envelope query string value is provided, will accept an empty payload and try to send the specified envelope.
   * This method replaces the definition of an existing bulk send list.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendListId  (required)
   * @param bulkSendingList  (optional)
   * @return BulkSendingList
   * @throws ApiException if fails to make API call
   */
  public BulkSendingList updateBulkSendList(String accountId, String bulkSendListId, BulkSendingList bulkSendingList) throws ApiException {
    ApiResponse<BulkSendingList> localVarResponse = updateBulkSendListWithHttpInfo(accountId, bulkSendListId, bulkSendingList);
    return localVarResponse.getData();
  }

  /**
   * Updates an existing bulk send list.  If send_envelope query string value is provided, will accept an empty payload and try to send the specified envelope
   * This method replaces the definition of an existing bulk send list.
   * @param accountId The external account number (int) or account ID Guid. (required)
   * @param bulkSendListId  (required)
   * @param bulkSendingList  (optional)
   * @return BulkSendingList
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BulkSendingList > updateBulkSendListWithHttpInfo(String accountId, String bulkSendListId, BulkSendingList bulkSendingList) throws ApiException {
    Object localVarPostBody = bulkSendingList;
    
    // verify the required parameter 'accountId' is set
    if (accountId == null) {
      throw new ApiException(400, "Missing the required parameter 'accountId' when calling updateBulkSendList");
    }
    
    // verify the required parameter 'bulkSendListId' is set
    if (bulkSendListId == null) {
      throw new ApiException(400, "Missing the required parameter 'bulkSendListId' when calling updateBulkSendList");
    }
    
    // create path and map variables
    String localVarPath = "/v2.1/accounts/{accountId}/bulk_send_lists/{bulkSendListId}"
      .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId.toString()))
      .replaceAll("\\{" + "bulkSendListId" + "\\}", apiClient.escapeString(bulkSendListId.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.List<Pair> localVarCollectionQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();

    

    

    

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "docusignAccessCode" };
    
    GenericType<BulkSendingList> localVarReturnType = new GenericType<BulkSendingList>() {};
    BulkSendingList localVarResponse = apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    return new ApiResponse<BulkSendingList>(apiClient.getStatusCode(), apiClient.getResponseHeaders(), localVarResponse);
  }
}
