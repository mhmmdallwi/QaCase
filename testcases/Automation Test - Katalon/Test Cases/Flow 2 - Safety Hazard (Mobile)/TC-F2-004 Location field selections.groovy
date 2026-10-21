/* Preconditions: the signed-in user has access to valid Location, Sublocation, and Area master-data values.
 * The product brief lists the three select fields but does not define cascading rules between them.
 */
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Hazard')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Report Hazard')
    CustomKeywords.'wemine.WeMineKeywords.selectMobileOption'('Location', CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_LOCATION'))
    CustomKeywords.'wemine.WeMineKeywords.selectMobileOption'('Sublocation', CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_SUBLOCATION'))
    CustomKeywords.'wemine.WeMineKeywords.selectMobileOption'('Area', CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_AREA'))
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'(CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_LOCATION'), 10)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'(CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_SUBLOCATION'), 10)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'(CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_AREA'), 10)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
