
package com.thesecretserver.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.thesecretserver.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetFolderResult_QNAME = new QName("urn:thesecretserver.com", "GetFolderResult");
    private final static QName _GetSecretTemplateFieldsResult_QNAME = new QName("urn:thesecretserver.com", "GetSecretTemplateFieldsResult");
    private final static QName _GetSecretResult_QNAME = new QName("urn:thesecretserver.com", "GetSecretResult");
    private final static QName _GetWebPasswordResult_QNAME = new QName("urn:thesecretserver.com", "GetWebPasswordResult");
    private final static QName _FileDownloadResult_QNAME = new QName("urn:thesecretserver.com", "FileDownloadResult");
    private final static QName _GetFavoritesResult_QNAME = new QName("urn:thesecretserver.com", "GetFavoritesResult");
    private final static QName _AddSecretResult_QNAME = new QName("urn:thesecretserver.com", "AddSecretResult");
    private final static QName _SearchFolderResult_QNAME = new QName("urn:thesecretserver.com", "SearchFolderResult");
    private final static QName _VersionGetResult_QNAME = new QName("urn:thesecretserver.com", "VersionGetResult");
    private final static QName _GetSecretTemplatesResult_QNAME = new QName("urn:thesecretserver.com", "GetSecretTemplatesResult");
    private final static QName _GetAgentsResult_QNAME = new QName("urn:thesecretserver.com", "GetAgentsResult");
    private final static QName _SearchSecretsResult_QNAME = new QName("urn:thesecretserver.com", "SearchSecretsResult");
    private final static QName _GetSecretsByFieldValueResult_QNAME = new QName("urn:thesecretserver.com", "GetSecretsByFieldValueResult");
    private final static QName _GeneratePasswordResult_QNAME = new QName("urn:thesecretserver.com", "GeneratePasswordResult");
    private final static QName _GetCheckOutStatusResult_QNAME = new QName("urn:thesecretserver.com", "GetCheckOutStatusResult");
    private final static QName _GetFoldersResult_QNAME = new QName("urn:thesecretserver.com", "GetFoldersResult");
    private final static QName _TokenIsValidResult_QNAME = new QName("urn:thesecretserver.com", "TokenIsValidResult");
    private final static QName _CreateFolderResult_QNAME = new QName("urn:thesecretserver.com", "CreateFolderResult");
    private final static QName _WebServiceResult_QNAME = new QName("urn:thesecretserver.com", "WebServiceResult");
    private final static QName _AuthenticateResult_QNAME = new QName("urn:thesecretserver.com", "AuthenticateResult");
    private final static QName _GetSecretAuditResult_QNAME = new QName("urn:thesecretserver.com", "GetSecretAuditResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.thesecretserver.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCheckOutStatusResult }
     * 
     */
    public GetCheckOutStatusResult createGetCheckOutStatusResult() {
        return new GetCheckOutStatusResult();
    }

    /**
     * Create an instance of {@link VersionGet }
     * 
     */
    public VersionGet createVersionGet() {
        return new VersionGet();
    }

    /**
     * Create an instance of {@link DownloadFileAttachmentByItemId }
     * 
     */
    public DownloadFileAttachmentByItemId createDownloadFileAttachmentByItemId() {
        return new DownloadFileAttachmentByItemId();
    }

    /**
     * Create an instance of {@link GetTokenIsValidResponse }
     * 
     */
    public GetTokenIsValidResponse createGetTokenIsValidResponse() {
        return new GetTokenIsValidResponse();
    }

    /**
     * Create an instance of {@link TokenIsValidResult }
     * 
     */
    public TokenIsValidResult createTokenIsValidResult() {
        return new TokenIsValidResult();
    }

    /**
     * Create an instance of {@link UpdateSecretResponse }
     * 
     */
    public UpdateSecretResponse createUpdateSecretResponse() {
        return new UpdateSecretResponse();
    }

    /**
     * Create an instance of {@link WebServiceResult }
     * 
     */
    public WebServiceResult createWebServiceResult() {
        return new WebServiceResult();
    }

    /**
     * Create an instance of {@link GetSecretTemplates }
     * 
     */
    public GetSecretTemplates createGetSecretTemplates() {
        return new GetSecretTemplates();
    }

    /**
     * Create an instance of {@link ImportXML }
     * 
     */
    public ImportXML createImportXML() {
        return new ImportXML();
    }

    /**
     * Create an instance of {@link GetSecretsByFieldValueResponse }
     * 
     */
    public GetSecretsByFieldValueResponse createGetSecretsByFieldValueResponse() {
        return new GetSecretsByFieldValueResponse();
    }

    /**
     * Create an instance of {@link GetSecretsByFieldValueResult }
     * 
     */
    public GetSecretsByFieldValueResult createGetSecretsByFieldValueResult() {
        return new GetSecretsByFieldValueResult();
    }

    /**
     * Create an instance of {@link AuthenticateRADIUS }
     * 
     */
    public AuthenticateRADIUS createAuthenticateRADIUS() {
        return new AuthenticateRADIUS();
    }

    /**
     * Create an instance of {@link GetSecretTemplatesResponse }
     * 
     */
    public GetSecretTemplatesResponse createGetSecretTemplatesResponse() {
        return new GetSecretTemplatesResponse();
    }

    /**
     * Create an instance of {@link GetSecretTemplatesResult }
     * 
     */
    public GetSecretTemplatesResult createGetSecretTemplatesResult() {
        return new GetSecretTemplatesResult();
    }

    /**
     * Create an instance of {@link VersionGetResponse }
     * 
     */
    public VersionGetResponse createVersionGetResponse() {
        return new VersionGetResponse();
    }

    /**
     * Create an instance of {@link VersionGetResult }
     * 
     */
    public VersionGetResult createVersionGetResult() {
        return new VersionGetResult();
    }

    /**
     * Create an instance of {@link GetSecretResponse }
     * 
     */
    public GetSecretResponse createGetSecretResponse() {
        return new GetSecretResponse();
    }

    /**
     * Create an instance of {@link GetSecretResult }
     * 
     */
    public GetSecretResult createGetSecretResult() {
        return new GetSecretResult();
    }

    /**
     * Create an instance of {@link GetFavorites }
     * 
     */
    public GetFavorites createGetFavorites() {
        return new GetFavorites();
    }

    /**
     * Create an instance of {@link GeneratePassword }
     * 
     */
    public GeneratePassword createGeneratePassword() {
        return new GeneratePassword();
    }

    /**
     * Create an instance of {@link GeneratePasswordResponse }
     * 
     */
    public GeneratePasswordResponse createGeneratePasswordResponse() {
        return new GeneratePasswordResponse();
    }

    /**
     * Create an instance of {@link GeneratePasswordResult }
     * 
     */
    public GeneratePasswordResult createGeneratePasswordResult() {
        return new GeneratePasswordResult();
    }

    /**
     * Create an instance of {@link GetSecretTemplateFields }
     * 
     */
    public GetSecretTemplateFields createGetSecretTemplateFields() {
        return new GetSecretTemplateFields();
    }

    /**
     * Create an instance of {@link SearchFoldersResponse }
     * 
     */
    public SearchFoldersResponse createSearchFoldersResponse() {
        return new SearchFoldersResponse();
    }

    /**
     * Create an instance of {@link SearchFolderResult }
     * 
     */
    public SearchFolderResult createSearchFolderResult() {
        return new SearchFolderResult();
    }

    /**
     * Create an instance of {@link FileDownloadResult }
     * 
     */
    public FileDownloadResult createFileDownloadResult() {
        return new FileDownloadResult();
    }

    /**
     * Create an instance of {@link SearchSecrets }
     * 
     */
    public SearchSecrets createSearchSecrets() {
        return new SearchSecrets();
    }

    /**
     * Create an instance of {@link AddSecretResult }
     * 
     */
    public AddSecretResult createAddSecretResult() {
        return new AddSecretResult();
    }

    /**
     * Create an instance of {@link SetCheckOutEnabled }
     * 
     */
    public SetCheckOutEnabled createSetCheckOutEnabled() {
        return new SetCheckOutEnabled();
    }

    /**
     * Create an instance of {@link DownloadFileAttachmentResponse }
     * 
     */
    public DownloadFileAttachmentResponse createDownloadFileAttachmentResponse() {
        return new DownloadFileAttachmentResponse();
    }

    /**
     * Create an instance of {@link AssignAgentResponse }
     * 
     */
    public AssignAgentResponse createAssignAgentResponse() {
        return new AssignAgentResponse();
    }

    /**
     * Create an instance of {@link AuthenticateResponse }
     * 
     */
    public AuthenticateResponse createAuthenticateResponse() {
        return new AuthenticateResponse();
    }

    /**
     * Create an instance of {@link AuthenticateResult }
     * 
     */
    public AuthenticateResult createAuthenticateResult() {
        return new AuthenticateResult();
    }

    /**
     * Create an instance of {@link SearchSecretsResponse }
     * 
     */
    public SearchSecretsResponse createSearchSecretsResponse() {
        return new SearchSecretsResponse();
    }

    /**
     * Create an instance of {@link SearchSecretsResult }
     * 
     */
    public SearchSecretsResult createSearchSecretsResult() {
        return new SearchSecretsResult();
    }

    /**
     * Create an instance of {@link FolderGet }
     * 
     */
    public FolderGet createFolderGet() {
        return new FolderGet();
    }

    /**
     * Create an instance of {@link ChangePassword }
     * 
     */
    public ChangePassword createChangePassword() {
        return new ChangePassword();
    }

    /**
     * Create an instance of {@link ExpireSecretResponse }
     * 
     */
    public ExpireSecretResponse createExpireSecretResponse() {
        return new ExpireSecretResponse();
    }

    /**
     * Create an instance of {@link UploadFileAttachmentByItemId }
     * 
     */
    public UploadFileAttachmentByItemId createUploadFileAttachmentByItemId() {
        return new UploadFileAttachmentByItemId();
    }

    /**
     * Create an instance of {@link UpdateIsFavoriteResponse }
     * 
     */
    public UpdateIsFavoriteResponse createUpdateIsFavoriteResponse() {
        return new UpdateIsFavoriteResponse();
    }

    /**
     * Create an instance of {@link GetSecretAuditResponse }
     * 
     */
    public GetSecretAuditResponse createGetSecretAuditResponse() {
        return new GetSecretAuditResponse();
    }

    /**
     * Create an instance of {@link GetSecretAuditResult }
     * 
     */
    public GetSecretAuditResult createGetSecretAuditResult() {
        return new GetSecretAuditResult();
    }

    /**
     * Create an instance of {@link SearchSecretsByFolder }
     * 
     */
    public SearchSecretsByFolder createSearchSecretsByFolder() {
        return new SearchSecretsByFolder();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link CreateFolderResult }
     * 
     */
    public CreateFolderResult createCreateFolderResult() {
        return new CreateFolderResult();
    }

    /**
     * Create an instance of {@link SetCheckOutEnabledResponse }
     * 
     */
    public SetCheckOutEnabledResponse createSetCheckOutEnabledResponse() {
        return new SetCheckOutEnabledResponse();
    }

    /**
     * Create an instance of {@link FolderGetAllChildren }
     * 
     */
    public FolderGetAllChildren createFolderGetAllChildren() {
        return new FolderGetAllChildren();
    }

    /**
     * Create an instance of {@link Authenticate }
     * 
     */
    public Authenticate createAuthenticate() {
        return new Authenticate();
    }

    /**
     * Create an instance of {@link FolderUpdate }
     * 
     */
    public FolderUpdate createFolderUpdate() {
        return new FolderUpdate();
    }

    /**
     * Create an instance of {@link Folder }
     * 
     */
    public Folder createFolder() {
        return new Folder();
    }

    /**
     * Create an instance of {@link GetSecretTemplateFieldsResponse }
     * 
     */
    public GetSecretTemplateFieldsResponse createGetSecretTemplateFieldsResponse() {
        return new GetSecretTemplateFieldsResponse();
    }

    /**
     * Create an instance of {@link GetSecretTemplateFieldsResult }
     * 
     */
    public GetSecretTemplateFieldsResult createGetSecretTemplateFieldsResult() {
        return new GetSecretTemplateFieldsResult();
    }

    /**
     * Create an instance of {@link GetFavoritesResponse }
     * 
     */
    public GetFavoritesResponse createGetFavoritesResponse() {
        return new GetFavoritesResponse();
    }

    /**
     * Create an instance of {@link GetFavoritesResult }
     * 
     */
    public GetFavoritesResult createGetFavoritesResult() {
        return new GetFavoritesResult();
    }

    /**
     * Create an instance of {@link FolderUpdateResponse }
     * 
     */
    public FolderUpdateResponse createFolderUpdateResponse() {
        return new FolderUpdateResponse();
    }

    /**
     * Create an instance of {@link AssignAgent }
     * 
     */
    public AssignAgent createAssignAgent() {
        return new AssignAgent();
    }

    /**
     * Create an instance of {@link SearchWebPasswordsForUrlResponse }
     * 
     */
    public SearchWebPasswordsForUrlResponse createSearchWebPasswordsForUrlResponse() {
        return new SearchWebPasswordsForUrlResponse();
    }

    /**
     * Create an instance of {@link GetWebPasswordResult }
     * 
     */
    public GetWebPasswordResult createGetWebPasswordResult() {
        return new GetWebPasswordResult();
    }

    /**
     * Create an instance of {@link GetSecretsByFieldValue }
     * 
     */
    public GetSecretsByFieldValue createGetSecretsByFieldValue() {
        return new GetSecretsByFieldValue();
    }

    /**
     * Create an instance of {@link GetFoldersResult }
     * 
     */
    public GetFoldersResult createGetFoldersResult() {
        return new GetFoldersResult();
    }

    /**
     * Create an instance of {@link DeactivateSecretResponse }
     * 
     */
    public DeactivateSecretResponse createDeactivateSecretResponse() {
        return new DeactivateSecretResponse();
    }

    /**
     * Create an instance of {@link FolderGetAllChildrenResponse }
     * 
     */
    public FolderGetAllChildrenResponse createFolderGetAllChildrenResponse() {
        return new FolderGetAllChildrenResponse();
    }

    /**
     * Create an instance of {@link DownloadFileAttachmentByItemIdResponse }
     * 
     */
    public DownloadFileAttachmentByItemIdResponse createDownloadFileAttachmentByItemIdResponse() {
        return new DownloadFileAttachmentByItemIdResponse();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link GetAgentsResult }
     * 
     */
    public GetAgentsResult createGetAgentsResult() {
        return new GetAgentsResult();
    }

    /**
     * Create an instance of {@link AuthenticateRADIUSResponse }
     * 
     */
    public AuthenticateRADIUSResponse createAuthenticateRADIUSResponse() {
        return new AuthenticateRADIUSResponse();
    }

    /**
     * Create an instance of {@link FolderGetResponse }
     * 
     */
    public FolderGetResponse createFolderGetResponse() {
        return new FolderGetResponse();
    }

    /**
     * Create an instance of {@link GetFolderResult }
     * 
     */
    public GetFolderResult createGetFolderResult() {
        return new GetFolderResult();
    }

    /**
     * Create an instance of {@link FolderCreate }
     * 
     */
    public FolderCreate createFolderCreate() {
        return new FolderCreate();
    }

    /**
     * Create an instance of {@link SearchFolders }
     * 
     */
    public SearchFolders createSearchFolders() {
        return new SearchFolders();
    }

    /**
     * Create an instance of {@link UploadFileAttachmentResponse }
     * 
     */
    public UploadFileAttachmentResponse createUploadFileAttachmentResponse() {
        return new UploadFileAttachmentResponse();
    }

    /**
     * Create an instance of {@link FolderCreateResponse }
     * 
     */
    public FolderCreateResponse createFolderCreateResponse() {
        return new FolderCreateResponse();
    }

    /**
     * Create an instance of {@link ImportXMLResponse }
     * 
     */
    public ImportXMLResponse createImportXMLResponse() {
        return new ImportXMLResponse();
    }

    /**
     * Create an instance of {@link SearchWebPasswordsForUrl }
     * 
     */
    public SearchWebPasswordsForUrl createSearchWebPasswordsForUrl() {
        return new SearchWebPasswordsForUrl();
    }

    /**
     * Create an instance of {@link GetCheckOutStatus }
     * 
     */
    public GetCheckOutStatus createGetCheckOutStatus() {
        return new GetCheckOutStatus();
    }

    /**
     * Create an instance of {@link DownloadFileAttachment }
     * 
     */
    public DownloadFileAttachment createDownloadFileAttachment() {
        return new DownloadFileAttachment();
    }

    /**
     * Create an instance of {@link UpdateIsFavorite }
     * 
     */
    public UpdateIsFavorite createUpdateIsFavorite() {
        return new UpdateIsFavorite();
    }

    /**
     * Create an instance of {@link GetSecretAudit }
     * 
     */
    public GetSecretAudit createGetSecretAudit() {
        return new GetSecretAudit();
    }

    /**
     * Create an instance of {@link GetTokenIsValid }
     * 
     */
    public GetTokenIsValid createGetTokenIsValid() {
        return new GetTokenIsValid();
    }

    /**
     * Create an instance of {@link AddSecret }
     * 
     */
    public AddSecret createAddSecret() {
        return new AddSecret();
    }

    /**
     * Create an instance of {@link ArrayOfInt }
     * 
     */
    public ArrayOfInt createArrayOfInt() {
        return new ArrayOfInt();
    }

    /**
     * Create an instance of {@link ArrayOfString }
     * 
     */
    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }

    /**
     * Create an instance of {@link SearchSecretsByFolderResponse }
     * 
     */
    public SearchSecretsByFolderResponse createSearchSecretsByFolderResponse() {
        return new SearchSecretsByFolderResponse();
    }

    /**
     * Create an instance of {@link GetAgentsResponse }
     * 
     */
    public GetAgentsResponse createGetAgentsResponse() {
        return new GetAgentsResponse();
    }

    /**
     * Create an instance of {@link ExpireSecret }
     * 
     */
    public ExpireSecret createExpireSecret() {
        return new ExpireSecret();
    }

    /**
     * Create an instance of {@link GetAgents }
     * 
     */
    public GetAgents createGetAgents() {
        return new GetAgents();
    }

    /**
     * Create an instance of {@link DeactivateSecret }
     * 
     */
    public DeactivateSecret createDeactivateSecret() {
        return new DeactivateSecret();
    }

    /**
     * Create an instance of {@link UploadFileAttachment }
     * 
     */
    public UploadFileAttachment createUploadFileAttachment() {
        return new UploadFileAttachment();
    }

    /**
     * Create an instance of {@link UpdateSecret }
     * 
     */
    public UpdateSecret createUpdateSecret() {
        return new UpdateSecret();
    }

    /**
     * Create an instance of {@link Secret }
     * 
     */
    public Secret createSecret() {
        return new Secret();
    }

    /**
     * Create an instance of {@link GetCheckOutStatusResponse }
     * 
     */
    public GetCheckOutStatusResponse createGetCheckOutStatusResponse() {
        return new GetCheckOutStatusResponse();
    }

    /**
     * Create an instance of {@link UploadFileAttachmentByItemIdResponse }
     * 
     */
    public UploadFileAttachmentByItemIdResponse createUploadFileAttachmentByItemIdResponse() {
        return new UploadFileAttachmentByItemIdResponse();
    }

    /**
     * Create an instance of {@link GetSecret }
     * 
     */
    public GetSecret createGetSecret() {
        return new GetSecret();
    }

    /**
     * Create an instance of {@link ChangePasswordResponse }
     * 
     */
    public ChangePasswordResponse createChangePasswordResponse() {
        return new ChangePasswordResponse();
    }

    /**
     * Create an instance of {@link AddSecretResponse }
     * 
     */
    public AddSecretResponse createAddSecretResponse() {
        return new AddSecretResponse();
    }

    /**
     * Create an instance of {@link SecretField }
     * 
     */
    public SecretField createSecretField() {
        return new SecretField();
    }

    /**
     * Create an instance of {@link AuditSecret }
     * 
     */
    public AuditSecret createAuditSecret() {
        return new AuditSecret();
    }

    /**
     * Create an instance of {@link ArrayOfSecretTemplate }
     * 
     */
    public ArrayOfSecretTemplate createArrayOfSecretTemplate() {
        return new ArrayOfSecretTemplate();
    }

    /**
     * Create an instance of {@link SecretTemplate }
     * 
     */
    public SecretTemplate createSecretTemplate() {
        return new SecretTemplate();
    }

    /**
     * Create an instance of {@link RemoteAgent }
     * 
     */
    public RemoteAgent createRemoteAgent() {
        return new RemoteAgent();
    }

    /**
     * Create an instance of {@link SecretItem }
     * 
     */
    public SecretItem createSecretItem() {
        return new SecretItem();
    }

    /**
     * Create an instance of {@link ArrayOfSecret }
     * 
     */
    public ArrayOfSecret createArrayOfSecret() {
        return new ArrayOfSecret();
    }

    /**
     * Create an instance of {@link ArrayOfSecretSummary }
     * 
     */
    public ArrayOfSecretSummary createArrayOfSecretSummary() {
        return new ArrayOfSecretSummary();
    }

    /**
     * Create an instance of {@link ArrayOfAuditSecret }
     * 
     */
    public ArrayOfAuditSecret createArrayOfAuditSecret() {
        return new ArrayOfAuditSecret();
    }

    /**
     * Create an instance of {@link ArrayOfSecretField }
     * 
     */
    public ArrayOfSecretField createArrayOfSecretField() {
        return new ArrayOfSecretField();
    }

    /**
     * Create an instance of {@link ArrayOfFolder }
     * 
     */
    public ArrayOfFolder createArrayOfFolder() {
        return new ArrayOfFolder();
    }

    /**
     * Create an instance of {@link ArrayOfRemoteAgent }
     * 
     */
    public ArrayOfRemoteAgent createArrayOfRemoteAgent() {
        return new ArrayOfRemoteAgent();
    }

    /**
     * Create an instance of {@link WebPassword }
     * 
     */
    public WebPassword createWebPassword() {
        return new WebPassword();
    }

    /**
     * Create an instance of {@link ArrayOfWebPassword }
     * 
     */
    public ArrayOfWebPassword createArrayOfWebPassword() {
        return new ArrayOfWebPassword();
    }

    /**
     * Create an instance of {@link SecretSummary }
     * 
     */
    public SecretSummary createSecretSummary() {
        return new SecretSummary();
    }

    /**
     * Create an instance of {@link ArrayOfSecretItem }
     * 
     */
    public ArrayOfSecretItem createArrayOfSecretItem() {
        return new ArrayOfSecretItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFolderResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "GetFolderResult")
    public JAXBElement<GetFolderResult> createGetFolderResult(GetFolderResult value) {
        return new JAXBElement<GetFolderResult>(_GetFolderResult_QNAME, GetFolderResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSecretTemplateFieldsResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "GetSecretTemplateFieldsResult")
    public JAXBElement<GetSecretTemplateFieldsResult> createGetSecretTemplateFieldsResult(GetSecretTemplateFieldsResult value) {
        return new JAXBElement<GetSecretTemplateFieldsResult>(_GetSecretTemplateFieldsResult_QNAME, GetSecretTemplateFieldsResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSecretResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "GetSecretResult")
    public JAXBElement<GetSecretResult> createGetSecretResult(GetSecretResult value) {
        return new JAXBElement<GetSecretResult>(_GetSecretResult_QNAME, GetSecretResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWebPasswordResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "GetWebPasswordResult")
    public JAXBElement<GetWebPasswordResult> createGetWebPasswordResult(GetWebPasswordResult value) {
        return new JAXBElement<GetWebPasswordResult>(_GetWebPasswordResult_QNAME, GetWebPasswordResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileDownloadResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "FileDownloadResult")
    public JAXBElement<FileDownloadResult> createFileDownloadResult(FileDownloadResult value) {
        return new JAXBElement<FileDownloadResult>(_FileDownloadResult_QNAME, FileDownloadResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFavoritesResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "GetFavoritesResult")
    public JAXBElement<GetFavoritesResult> createGetFavoritesResult(GetFavoritesResult value) {
        return new JAXBElement<GetFavoritesResult>(_GetFavoritesResult_QNAME, GetFavoritesResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSecretResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "AddSecretResult")
    public JAXBElement<AddSecretResult> createAddSecretResult(AddSecretResult value) {
        return new JAXBElement<AddSecretResult>(_AddSecretResult_QNAME, AddSecretResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchFolderResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "SearchFolderResult")
    public JAXBElement<SearchFolderResult> createSearchFolderResult(SearchFolderResult value) {
        return new JAXBElement<SearchFolderResult>(_SearchFolderResult_QNAME, SearchFolderResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VersionGetResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "VersionGetResult")
    public JAXBElement<VersionGetResult> createVersionGetResult(VersionGetResult value) {
        return new JAXBElement<VersionGetResult>(_VersionGetResult_QNAME, VersionGetResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSecretTemplatesResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "GetSecretTemplatesResult")
    public JAXBElement<GetSecretTemplatesResult> createGetSecretTemplatesResult(GetSecretTemplatesResult value) {
        return new JAXBElement<GetSecretTemplatesResult>(_GetSecretTemplatesResult_QNAME, GetSecretTemplatesResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAgentsResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "GetAgentsResult")
    public JAXBElement<GetAgentsResult> createGetAgentsResult(GetAgentsResult value) {
        return new JAXBElement<GetAgentsResult>(_GetAgentsResult_QNAME, GetAgentsResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchSecretsResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "SearchSecretsResult")
    public JAXBElement<SearchSecretsResult> createSearchSecretsResult(SearchSecretsResult value) {
        return new JAXBElement<SearchSecretsResult>(_SearchSecretsResult_QNAME, SearchSecretsResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSecretsByFieldValueResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "GetSecretsByFieldValueResult")
    public JAXBElement<GetSecretsByFieldValueResult> createGetSecretsByFieldValueResult(GetSecretsByFieldValueResult value) {
        return new JAXBElement<GetSecretsByFieldValueResult>(_GetSecretsByFieldValueResult_QNAME, GetSecretsByFieldValueResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneratePasswordResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "GeneratePasswordResult")
    public JAXBElement<GeneratePasswordResult> createGeneratePasswordResult(GeneratePasswordResult value) {
        return new JAXBElement<GeneratePasswordResult>(_GeneratePasswordResult_QNAME, GeneratePasswordResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCheckOutStatusResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "GetCheckOutStatusResult")
    public JAXBElement<GetCheckOutStatusResult> createGetCheckOutStatusResult(GetCheckOutStatusResult value) {
        return new JAXBElement<GetCheckOutStatusResult>(_GetCheckOutStatusResult_QNAME, GetCheckOutStatusResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFoldersResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "GetFoldersResult")
    public JAXBElement<GetFoldersResult> createGetFoldersResult(GetFoldersResult value) {
        return new JAXBElement<GetFoldersResult>(_GetFoldersResult_QNAME, GetFoldersResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TokenIsValidResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "TokenIsValidResult")
    public JAXBElement<TokenIsValidResult> createTokenIsValidResult(TokenIsValidResult value) {
        return new JAXBElement<TokenIsValidResult>(_TokenIsValidResult_QNAME, TokenIsValidResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateFolderResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "CreateFolderResult")
    public JAXBElement<CreateFolderResult> createCreateFolderResult(CreateFolderResult value) {
        return new JAXBElement<CreateFolderResult>(_CreateFolderResult_QNAME, CreateFolderResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WebServiceResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "WebServiceResult")
    public JAXBElement<WebServiceResult> createWebServiceResult(WebServiceResult value) {
        return new JAXBElement<WebServiceResult>(_WebServiceResult_QNAME, WebServiceResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticateResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "AuthenticateResult")
    public JAXBElement<AuthenticateResult> createAuthenticateResult(AuthenticateResult value) {
        return new JAXBElement<AuthenticateResult>(_AuthenticateResult_QNAME, AuthenticateResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSecretAuditResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:thesecretserver.com", name = "GetSecretAuditResult")
    public JAXBElement<GetSecretAuditResult> createGetSecretAuditResult(GetSecretAuditResult value) {
        return new JAXBElement<GetSecretAuditResult>(_GetSecretAuditResult_QNAME, GetSecretAuditResult.class, null, value);
    }

}