/**
 * Cross-platform integration: WeMineOffice Form Builder configuration is consumed by WeMine Mobile.
 * Preconditions: a form has been configured in WeMineOffice with the supplied Form Code and the
 * labels below, and is in whatever product-defined state makes it available to mobile users.
 * The brief does not define a Publish/Sync control, so this test deliberately does not invent one.
 */
String formCode = CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_EQUIPMENT_FORM_CODE')
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Equipment Inspection')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('New Inspection')
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Form Code', formCode)
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Load Form')
    // These labels must exist on the test form configured through WeMineOffice.
    ['Inspection Notes', 'Inspection Date', 'Condition', 'Result', 'Evidence'].each { label ->
        CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'(label, 10)
    }
} finally {
    CustomKeywords.'wemine.WeMineKeywords.closeMobile'()
}
