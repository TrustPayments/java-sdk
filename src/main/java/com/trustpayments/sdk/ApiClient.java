package com.trustpayments.sdk;

import com.trustpayments.sdk.service.*;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.Json;
import com.google.api.client.http.HttpHeaders;

import java.io.IOException;
import java.io.OutputStream;


public class ApiClient {
    private int readTimeOut = 25;
    private final String basePath;
    private final HttpRequestFactory httpRequestFactory;
    private final ObjectMapper objectMapper;
    private final long userId;
    private final String applicationKey;
    private final Map<String, String> defaultHeaders;

    // A reasonable default object mapper. Client can pass in a chosen ObjectMapper anyway, this is just for reasonable defaults.
    private static ObjectMapper createDefaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .setDateFormat(new RFC3339DateFormat())
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }


    /**
     * Constructor for ApiClient
     *
     * @param userId
     * @param applicationKey
     */
    public ApiClient(long userId, String applicationKey) {
		this(userId, applicationKey, "https://ep.trustpayments.com:443/api");
	}

    /**
     * Constructor for ApiClient
     *
     * @param userId
     * @param applicationKey
     */
    public ApiClient(long userId, String applicationKey, String basePath) {
        if (applicationKey == null || applicationKey.trim().isEmpty()) {
            throw new IllegalArgumentException("The application key cannot be empty or null.");
        }
        if (userId < 1) {
            throw new IllegalArgumentException("The user id is invalid.");
        }
        if (basePath == null || basePath.trim().isEmpty()) {
	        throw new IllegalArgumentException("The base path cannot be empty.");
	    }
	    
		this.basePath = basePath;
        this.userId = userId;
        this.applicationKey = applicationKey;
        this.defaultHeaders = new HashMap<>();
        this.httpRequestFactory = this.createRequestFactory();
        this.objectMapper = createDefaultObjectMapper();
    }

    public HttpRequestFactory getHttpRequestFactory() {
        return httpRequestFactory;
    }

    public HttpRequestFactory createRequestFactory() {
        final RequestInterceptor interceptor = new RequestInterceptor(this.userId, this.applicationKey, this.defaultHeaders);
        NetHttpTransport transport = new NetHttpTransport();
        return transport.createRequestFactory(new HttpRequestInitializer() {
            public void initialize(HttpRequest request) {
                request.setInterceptor(interceptor);
            }
        });
    }

    public void addDefaultHeader (String key, String value) {
        this.defaultHeaders.put(key, value);
    }

    public String getBasePath() {
        return basePath;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public int getReadTimeOut() {
        return readTimeOut;
    }

    public void setReadTimeOut(int readTimeOut) {
        this.readTimeOut = readTimeOut;
    }

    public class JacksonJsonHttpContent extends AbstractHttpContent {
        /* A POJO that can be serialized with a com.fasterxml Jackson ObjectMapper */
        private final Object data;

        public JacksonJsonHttpContent(Object data) {
            super(Json.MEDIA_TYPE);
            this.data = data;
        }

        @Override
        public void writeTo(OutputStream out) throws IOException {
            objectMapper.writeValue(out, data);
        }
    }

    // Builder pattern to get API instances for this client.
    
    private AccountService accountService;
    public AccountService getAccountService() {
        if (this.accountService == null) {
            this.accountService = new AccountService(this);
        }
        return this.accountService;
    }
    
    private ApplicationUserService applicationUserService;
    public ApplicationUserService getApplicationUserService() {
        if (this.applicationUserService == null) {
            this.applicationUserService = new ApplicationUserService(this);
        }
        return this.applicationUserService;
    }
    
    private CardProcessingService cardProcessingService;
    public CardProcessingService getCardProcessingService() {
        if (this.cardProcessingService == null) {
            this.cardProcessingService = new CardProcessingService(this);
        }
        return this.cardProcessingService;
    }
    
    private ChargeAttemptService chargeAttemptService;
    public ChargeAttemptService getChargeAttemptService() {
        if (this.chargeAttemptService == null) {
            this.chargeAttemptService = new ChargeAttemptService(this);
        }
        return this.chargeAttemptService;
    }
    
    private ChargeFlowLevelPaymentLinkService chargeFlowLevelPaymentLinkService;
    public ChargeFlowLevelPaymentLinkService getChargeFlowLevelPaymentLinkService() {
        if (this.chargeFlowLevelPaymentLinkService == null) {
            this.chargeFlowLevelPaymentLinkService = new ChargeFlowLevelPaymentLinkService(this);
        }
        return this.chargeFlowLevelPaymentLinkService;
    }
    
    private ChargeFlowLevelService chargeFlowLevelService;
    public ChargeFlowLevelService getChargeFlowLevelService() {
        if (this.chargeFlowLevelService == null) {
            this.chargeFlowLevelService = new ChargeFlowLevelService(this);
        }
        return this.chargeFlowLevelService;
    }
    
    private ChargeFlowService chargeFlowService;
    public ChargeFlowService getChargeFlowService() {
        if (this.chargeFlowService == null) {
            this.chargeFlowService = new ChargeFlowService(this);
        }
        return this.chargeFlowService;
    }
    
    private ConditionTypeService conditionTypeService;
    public ConditionTypeService getConditionTypeService() {
        if (this.conditionTypeService == null) {
            this.conditionTypeService = new ConditionTypeService(this);
        }
        return this.conditionTypeService;
    }
    
    private CountryService countryService;
    public CountryService getCountryService() {
        if (this.countryService == null) {
            this.countryService = new CountryService(this);
        }
        return this.countryService;
    }
    
    private CountryStateService countryStateService;
    public CountryStateService getCountryStateService() {
        if (this.countryStateService == null) {
            this.countryStateService = new CountryStateService(this);
        }
        return this.countryStateService;
    }
    
    private CurrencyService currencyService;
    public CurrencyService getCurrencyService() {
        if (this.currencyService == null) {
            this.currencyService = new CurrencyService(this);
        }
        return this.currencyService;
    }
    
    private CustomerAddressService customerAddressService;
    public CustomerAddressService getCustomerAddressService() {
        if (this.customerAddressService == null) {
            this.customerAddressService = new CustomerAddressService(this);
        }
        return this.customerAddressService;
    }
    
    private CustomerCommentService customerCommentService;
    public CustomerCommentService getCustomerCommentService() {
        if (this.customerCommentService == null) {
            this.customerCommentService = new CustomerCommentService(this);
        }
        return this.customerCommentService;
    }
    
    private CustomerService customerService;
    public CustomerService getCustomerService() {
        if (this.customerService == null) {
            this.customerService = new CustomerService(this);
        }
        return this.customerService;
    }
    
    private DeliveryIndicationService deliveryIndicationService;
    public DeliveryIndicationService getDeliveryIndicationService() {
        if (this.deliveryIndicationService == null) {
            this.deliveryIndicationService = new DeliveryIndicationService(this);
        }
        return this.deliveryIndicationService;
    }
    
    private DocumentTemplateService documentTemplateService;
    public DocumentTemplateService getDocumentTemplateService() {
        if (this.documentTemplateService == null) {
            this.documentTemplateService = new DocumentTemplateService(this);
        }
        return this.documentTemplateService;
    }
    
    private DocumentTemplateTypeService documentTemplateTypeService;
    public DocumentTemplateTypeService getDocumentTemplateTypeService() {
        if (this.documentTemplateTypeService == null) {
            this.documentTemplateTypeService = new DocumentTemplateTypeService(this);
        }
        return this.documentTemplateTypeService;
    }
    
    private HumanUserService humanUserService;
    public HumanUserService getHumanUserService() {
        if (this.humanUserService == null) {
            this.humanUserService = new HumanUserService(this);
        }
        return this.humanUserService;
    }
    
    private LabelDescriptionGroupService labelDescriptionGroupService;
    public LabelDescriptionGroupService getLabelDescriptionGroupService() {
        if (this.labelDescriptionGroupService == null) {
            this.labelDescriptionGroupService = new LabelDescriptionGroupService(this);
        }
        return this.labelDescriptionGroupService;
    }
    
    private LabelDescriptionService labelDescriptionService;
    public LabelDescriptionService getLabelDescriptionService() {
        if (this.labelDescriptionService == null) {
            this.labelDescriptionService = new LabelDescriptionService(this);
        }
        return this.labelDescriptionService;
    }
    
    private LanguageService languageService;
    public LanguageService getLanguageService() {
        if (this.languageService == null) {
            this.languageService = new LanguageService(this);
        }
        return this.languageService;
    }
    
    private LegalOrganizationFormService legalOrganizationFormService;
    public LegalOrganizationFormService getLegalOrganizationFormService() {
        if (this.legalOrganizationFormService == null) {
            this.legalOrganizationFormService = new LegalOrganizationFormService(this);
        }
        return this.legalOrganizationFormService;
    }
    
    private ManualTaskService manualTaskService;
    public ManualTaskService getManualTaskService() {
        if (this.manualTaskService == null) {
            this.manualTaskService = new ManualTaskService(this);
        }
        return this.manualTaskService;
    }
    
    private PaymentConnectorConfigurationService paymentConnectorConfigurationService;
    public PaymentConnectorConfigurationService getPaymentConnectorConfigurationService() {
        if (this.paymentConnectorConfigurationService == null) {
            this.paymentConnectorConfigurationService = new PaymentConnectorConfigurationService(this);
        }
        return this.paymentConnectorConfigurationService;
    }
    
    private PaymentConnectorService paymentConnectorService;
    public PaymentConnectorService getPaymentConnectorService() {
        if (this.paymentConnectorService == null) {
            this.paymentConnectorService = new PaymentConnectorService(this);
        }
        return this.paymentConnectorService;
    }
    
    private PaymentLinkService paymentLinkService;
    public PaymentLinkService getPaymentLinkService() {
        if (this.paymentLinkService == null) {
            this.paymentLinkService = new PaymentLinkService(this);
        }
        return this.paymentLinkService;
    }
    
    private PaymentMethodBrandService paymentMethodBrandService;
    public PaymentMethodBrandService getPaymentMethodBrandService() {
        if (this.paymentMethodBrandService == null) {
            this.paymentMethodBrandService = new PaymentMethodBrandService(this);
        }
        return this.paymentMethodBrandService;
    }
    
    private PaymentMethodConfigurationService paymentMethodConfigurationService;
    public PaymentMethodConfigurationService getPaymentMethodConfigurationService() {
        if (this.paymentMethodConfigurationService == null) {
            this.paymentMethodConfigurationService = new PaymentMethodConfigurationService(this);
        }
        return this.paymentMethodConfigurationService;
    }
    
    private PaymentMethodService paymentMethodService;
    public PaymentMethodService getPaymentMethodService() {
        if (this.paymentMethodService == null) {
            this.paymentMethodService = new PaymentMethodService(this);
        }
        return this.paymentMethodService;
    }
    
    private PaymentProcessorConfigurationService paymentProcessorConfigurationService;
    public PaymentProcessorConfigurationService getPaymentProcessorConfigurationService() {
        if (this.paymentProcessorConfigurationService == null) {
            this.paymentProcessorConfigurationService = new PaymentProcessorConfigurationService(this);
        }
        return this.paymentProcessorConfigurationService;
    }
    
    private PaymentProcessorService paymentProcessorService;
    public PaymentProcessorService getPaymentProcessorService() {
        if (this.paymentProcessorService == null) {
            this.paymentProcessorService = new PaymentProcessorService(this);
        }
        return this.paymentProcessorService;
    }
    
    private PaymentTerminalService paymentTerminalService;
    public PaymentTerminalService getPaymentTerminalService() {
        if (this.paymentTerminalService == null) {
            this.paymentTerminalService = new PaymentTerminalService(this);
        }
        return this.paymentTerminalService;
    }
    
    private PaymentTerminalTillService paymentTerminalTillService;
    public PaymentTerminalTillService getPaymentTerminalTillService() {
        if (this.paymentTerminalTillService == null) {
            this.paymentTerminalTillService = new PaymentTerminalTillService(this);
        }
        return this.paymentTerminalTillService;
    }
    
    private PaymentTerminalTransactionSummaryService paymentTerminalTransactionSummaryService;
    public PaymentTerminalTransactionSummaryService getPaymentTerminalTransactionSummaryService() {
        if (this.paymentTerminalTransactionSummaryService == null) {
            this.paymentTerminalTransactionSummaryService = new PaymentTerminalTransactionSummaryService(this);
        }
        return this.paymentTerminalTransactionSummaryService;
    }
    
    private PermissionService permissionService;
    public PermissionService getPermissionService() {
        if (this.permissionService == null) {
            this.permissionService = new PermissionService(this);
        }
        return this.permissionService;
    }
    
    private RefundCommentService refundCommentService;
    public RefundCommentService getRefundCommentService() {
        if (this.refundCommentService == null) {
            this.refundCommentService = new RefundCommentService(this);
        }
        return this.refundCommentService;
    }
    
    private RefundService refundService;
    public RefundService getRefundService() {
        if (this.refundService == null) {
            this.refundService = new RefundService(this);
        }
        return this.refundService;
    }
    
    private ShopifyTransactionService shopifyTransactionService;
    public ShopifyTransactionService getShopifyTransactionService() {
        if (this.shopifyTransactionService == null) {
            this.shopifyTransactionService = new ShopifyTransactionService(this);
        }
        return this.shopifyTransactionService;
    }
    
    private SpaceService spaceService;
    public SpaceService getSpaceService() {
        if (this.spaceService == null) {
            this.spaceService = new SpaceService(this);
        }
        return this.spaceService;
    }
    
    private StaticValueService staticValueService;
    public StaticValueService getStaticValueService() {
        if (this.staticValueService == null) {
            this.staticValueService = new StaticValueService(this);
        }
        return this.staticValueService;
    }
    
    private SubscriberService subscriberService;
    public SubscriberService getSubscriberService() {
        if (this.subscriberService == null) {
            this.subscriberService = new SubscriberService(this);
        }
        return this.subscriberService;
    }
    
    private SubscriptionAffiliateService subscriptionAffiliateService;
    public SubscriptionAffiliateService getSubscriptionAffiliateService() {
        if (this.subscriptionAffiliateService == null) {
            this.subscriptionAffiliateService = new SubscriptionAffiliateService(this);
        }
        return this.subscriptionAffiliateService;
    }
    
    private SubscriptionChargeService subscriptionChargeService;
    public SubscriptionChargeService getSubscriptionChargeService() {
        if (this.subscriptionChargeService == null) {
            this.subscriptionChargeService = new SubscriptionChargeService(this);
        }
        return this.subscriptionChargeService;
    }
    
    private SubscriptionLedgerEntryService subscriptionLedgerEntryService;
    public SubscriptionLedgerEntryService getSubscriptionLedgerEntryService() {
        if (this.subscriptionLedgerEntryService == null) {
            this.subscriptionLedgerEntryService = new SubscriptionLedgerEntryService(this);
        }
        return this.subscriptionLedgerEntryService;
    }
    
    private SubscriptionMetricService subscriptionMetricService;
    public SubscriptionMetricService getSubscriptionMetricService() {
        if (this.subscriptionMetricService == null) {
            this.subscriptionMetricService = new SubscriptionMetricService(this);
        }
        return this.subscriptionMetricService;
    }
    
    private SubscriptionMetricUsageService subscriptionMetricUsageService;
    public SubscriptionMetricUsageService getSubscriptionMetricUsageService() {
        if (this.subscriptionMetricUsageService == null) {
            this.subscriptionMetricUsageService = new SubscriptionMetricUsageService(this);
        }
        return this.subscriptionMetricUsageService;
    }
    
    private SubscriptionPeriodBillService subscriptionPeriodBillService;
    public SubscriptionPeriodBillService getSubscriptionPeriodBillService() {
        if (this.subscriptionPeriodBillService == null) {
            this.subscriptionPeriodBillService = new SubscriptionPeriodBillService(this);
        }
        return this.subscriptionPeriodBillService;
    }
    
    private SubscriptionProductComponentGroupService subscriptionProductComponentGroupService;
    public SubscriptionProductComponentGroupService getSubscriptionProductComponentGroupService() {
        if (this.subscriptionProductComponentGroupService == null) {
            this.subscriptionProductComponentGroupService = new SubscriptionProductComponentGroupService(this);
        }
        return this.subscriptionProductComponentGroupService;
    }
    
    private SubscriptionProductComponentService subscriptionProductComponentService;
    public SubscriptionProductComponentService getSubscriptionProductComponentService() {
        if (this.subscriptionProductComponentService == null) {
            this.subscriptionProductComponentService = new SubscriptionProductComponentService(this);
        }
        return this.subscriptionProductComponentService;
    }
    
    private SubscriptionProductFeeTierService subscriptionProductFeeTierService;
    public SubscriptionProductFeeTierService getSubscriptionProductFeeTierService() {
        if (this.subscriptionProductFeeTierService == null) {
            this.subscriptionProductFeeTierService = new SubscriptionProductFeeTierService(this);
        }
        return this.subscriptionProductFeeTierService;
    }
    
    private SubscriptionProductMeteredFeeService subscriptionProductMeteredFeeService;
    public SubscriptionProductMeteredFeeService getSubscriptionProductMeteredFeeService() {
        if (this.subscriptionProductMeteredFeeService == null) {
            this.subscriptionProductMeteredFeeService = new SubscriptionProductMeteredFeeService(this);
        }
        return this.subscriptionProductMeteredFeeService;
    }
    
    private SubscriptionProductPeriodFeeService subscriptionProductPeriodFeeService;
    public SubscriptionProductPeriodFeeService getSubscriptionProductPeriodFeeService() {
        if (this.subscriptionProductPeriodFeeService == null) {
            this.subscriptionProductPeriodFeeService = new SubscriptionProductPeriodFeeService(this);
        }
        return this.subscriptionProductPeriodFeeService;
    }
    
    private SubscriptionProductRetirementService subscriptionProductRetirementService;
    public SubscriptionProductRetirementService getSubscriptionProductRetirementService() {
        if (this.subscriptionProductRetirementService == null) {
            this.subscriptionProductRetirementService = new SubscriptionProductRetirementService(this);
        }
        return this.subscriptionProductRetirementService;
    }
    
    private SubscriptionProductService subscriptionProductService;
    public SubscriptionProductService getSubscriptionProductService() {
        if (this.subscriptionProductService == null) {
            this.subscriptionProductService = new SubscriptionProductService(this);
        }
        return this.subscriptionProductService;
    }
    
    private SubscriptionProductSetupFeeService subscriptionProductSetupFeeService;
    public SubscriptionProductSetupFeeService getSubscriptionProductSetupFeeService() {
        if (this.subscriptionProductSetupFeeService == null) {
            this.subscriptionProductSetupFeeService = new SubscriptionProductSetupFeeService(this);
        }
        return this.subscriptionProductSetupFeeService;
    }
    
    private SubscriptionProductVersionRetirementService subscriptionProductVersionRetirementService;
    public SubscriptionProductVersionRetirementService getSubscriptionProductVersionRetirementService() {
        if (this.subscriptionProductVersionRetirementService == null) {
            this.subscriptionProductVersionRetirementService = new SubscriptionProductVersionRetirementService(this);
        }
        return this.subscriptionProductVersionRetirementService;
    }
    
    private SubscriptionProductVersionService subscriptionProductVersionService;
    public SubscriptionProductVersionService getSubscriptionProductVersionService() {
        if (this.subscriptionProductVersionService == null) {
            this.subscriptionProductVersionService = new SubscriptionProductVersionService(this);
        }
        return this.subscriptionProductVersionService;
    }
    
    private SubscriptionService subscriptionService;
    public SubscriptionService getSubscriptionService() {
        if (this.subscriptionService == null) {
            this.subscriptionService = new SubscriptionService(this);
        }
        return this.subscriptionService;
    }
    
    private SubscriptionSuspensionService subscriptionSuspensionService;
    public SubscriptionSuspensionService getSubscriptionSuspensionService() {
        if (this.subscriptionSuspensionService == null) {
            this.subscriptionSuspensionService = new SubscriptionSuspensionService(this);
        }
        return this.subscriptionSuspensionService;
    }
    
    private SubscriptionVersionService subscriptionVersionService;
    public SubscriptionVersionService getSubscriptionVersionService() {
        if (this.subscriptionVersionService == null) {
            this.subscriptionVersionService = new SubscriptionVersionService(this);
        }
        return this.subscriptionVersionService;
    }
    
    private TokenService tokenService;
    public TokenService getTokenService() {
        if (this.tokenService == null) {
            this.tokenService = new TokenService(this);
        }
        return this.tokenService;
    }
    
    private TokenVersionService tokenVersionService;
    public TokenVersionService getTokenVersionService() {
        if (this.tokenVersionService == null) {
            this.tokenVersionService = new TokenVersionService(this);
        }
        return this.tokenVersionService;
    }
    
    private TransactionCommentService transactionCommentService;
    public TransactionCommentService getTransactionCommentService() {
        if (this.transactionCommentService == null) {
            this.transactionCommentService = new TransactionCommentService(this);
        }
        return this.transactionCommentService;
    }
    
    private TransactionCompletionService transactionCompletionService;
    public TransactionCompletionService getTransactionCompletionService() {
        if (this.transactionCompletionService == null) {
            this.transactionCompletionService = new TransactionCompletionService(this);
        }
        return this.transactionCompletionService;
    }
    
    private TransactionIframeService transactionIframeService;
    public TransactionIframeService getTransactionIframeService() {
        if (this.transactionIframeService == null) {
            this.transactionIframeService = new TransactionIframeService(this);
        }
        return this.transactionIframeService;
    }
    
    private TransactionInvoiceCommentService transactionInvoiceCommentService;
    public TransactionInvoiceCommentService getTransactionInvoiceCommentService() {
        if (this.transactionInvoiceCommentService == null) {
            this.transactionInvoiceCommentService = new TransactionInvoiceCommentService(this);
        }
        return this.transactionInvoiceCommentService;
    }
    
    private TransactionInvoiceService transactionInvoiceService;
    public TransactionInvoiceService getTransactionInvoiceService() {
        if (this.transactionInvoiceService == null) {
            this.transactionInvoiceService = new TransactionInvoiceService(this);
        }
        return this.transactionInvoiceService;
    }
    
    private TransactionLightboxService transactionLightboxService;
    public TransactionLightboxService getTransactionLightboxService() {
        if (this.transactionLightboxService == null) {
            this.transactionLightboxService = new TransactionLightboxService(this);
        }
        return this.transactionLightboxService;
    }
    
    private TransactionLineItemVersionService transactionLineItemVersionService;
    public TransactionLineItemVersionService getTransactionLineItemVersionService() {
        if (this.transactionLineItemVersionService == null) {
            this.transactionLineItemVersionService = new TransactionLineItemVersionService(this);
        }
        return this.transactionLineItemVersionService;
    }
    
    private TransactionMobileSdkService transactionMobileSdkService;
    public TransactionMobileSdkService getTransactionMobileSdkService() {
        if (this.transactionMobileSdkService == null) {
            this.transactionMobileSdkService = new TransactionMobileSdkService(this);
        }
        return this.transactionMobileSdkService;
    }
    
    private TransactionPaymentPageService transactionPaymentPageService;
    public TransactionPaymentPageService getTransactionPaymentPageService() {
        if (this.transactionPaymentPageService == null) {
            this.transactionPaymentPageService = new TransactionPaymentPageService(this);
        }
        return this.transactionPaymentPageService;
    }
    
    private TransactionService transactionService;
    public TransactionService getTransactionService() {
        if (this.transactionService == null) {
            this.transactionService = new TransactionService(this);
        }
        return this.transactionService;
    }
    
    private TransactionTerminalService transactionTerminalService;
    public TransactionTerminalService getTransactionTerminalService() {
        if (this.transactionTerminalService == null) {
            this.transactionTerminalService = new TransactionTerminalService(this);
        }
        return this.transactionTerminalService;
    }
    
    private TransactionVoidService transactionVoidService;
    public TransactionVoidService getTransactionVoidService() {
        if (this.transactionVoidService == null) {
            this.transactionVoidService = new TransactionVoidService(this);
        }
        return this.transactionVoidService;
    }
    
    private UserAccountRoleService userAccountRoleService;
    public UserAccountRoleService getUserAccountRoleService() {
        if (this.userAccountRoleService == null) {
            this.userAccountRoleService = new UserAccountRoleService(this);
        }
        return this.userAccountRoleService;
    }
    
    private UserSpaceRoleService userSpaceRoleService;
    public UserSpaceRoleService getUserSpaceRoleService() {
        if (this.userSpaceRoleService == null) {
            this.userSpaceRoleService = new UserSpaceRoleService(this);
        }
        return this.userSpaceRoleService;
    }
    
    private WebhookListenerService webhookListenerService;
    public WebhookListenerService getWebhookListenerService() {
        if (this.webhookListenerService == null) {
            this.webhookListenerService = new WebhookListenerService(this);
        }
        return this.webhookListenerService;
    }
    
    private WebhookUrlService webhookUrlService;
    public WebhookUrlService getWebhookUrlService() {
        if (this.webhookUrlService == null) {
            this.webhookUrlService = new WebhookUrlService(this);
        }
        return this.webhookUrlService;
    }
    
}
