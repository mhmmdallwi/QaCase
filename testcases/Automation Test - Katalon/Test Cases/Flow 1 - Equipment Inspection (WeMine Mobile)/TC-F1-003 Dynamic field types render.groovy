// Preconditions: form EQ-001 is configured with one of each supported field type and is published.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Equipment Inspection')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('New Inspection')
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Form Code', CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_EQUIPMENT_FORM_CODE'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Load Form')
    ['Inspection Notes', 'Inspection Date', 'Condition', 'Result', 'Evidence'].each { label ->
        CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'(label, 10)
    }
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
