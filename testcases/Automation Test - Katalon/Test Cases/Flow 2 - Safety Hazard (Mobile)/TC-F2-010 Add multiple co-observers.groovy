// Preconditions: open follow-up task; at least two eligible employees exist in master data.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Follow-up')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Open Task')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'(System.getenv('WEMINE_ADD_CO_OBSERVER_LABEL') ?: '+')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'(CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_CO_OBSERVER_1'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'(System.getenv('WEMINE_ADD_CO_OBSERVER_LABEL') ?: '+')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'(CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_CO_OBSERVER_2'))
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'(CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_CO_OBSERVER_1'), 10)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'(CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_CO_OBSERVER_2'), 10)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
