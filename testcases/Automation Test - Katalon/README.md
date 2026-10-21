# WeMine Test Automation — Katalon Studio

## Scope

This project covers the flows described in the Project WeMine brief for WeMine Mobile and WeMineOffice Web. Sign-in cases are separated by platform. Form Builder cases run on WeMineOffice Web, and Safety Hazard and follow-up cases run on WeMine Mobile. Equipment Inspection is treated as a cross-platform workflow: forms are configured in WeMineOffice Web and consumed in WeMine Mobile. This is the best-fit interpretation of the supplied brief and the user clarification; exact publish/sync controls remain unspecified.

## Project contents

- `Test Cases/` — Groovy automation scripts and Katalon test-case metadata.
- `Test Suites/` — suites grouped by feature and platform.
- `Keywords/wemine/WeMineKeywords.groovy` — shared mobile/web interactions and environment checks.
- `Data Files/wemine_test_data.csv` — sample data layout; replace values with fixtures from the test environment.
- `MANUAL_TEST_CASES.md` — individual test cases, steps, expected results, and platform.
- `EXECUTION_CHECKLIST.md` — setup and run checklist.
- `REVIEW_NOTES.md` — review findings and items that still need product confirmation.

## Configuration

Set these environment variables before running the relevant suites:

- `WEMINE_APP_PATH` — path to the Android APK.
- `WEMINE_TEST_USERNAME` — valid WeMine username for the test tenant.
- `WEMINE_MOBILE_HOME_MARKER` — stable text visible after mobile sign-in.
- `WEMINE_UNKNOWN_USERNAME` — username confirmed not to exist in the test environment.
- `WEMINE_MS_USERNAME`, `WEMINE_MS_PASSWORD` — dedicated Microsoft test account, if the login flow requires credentials.
- `WEMINEOFFICE_BASE_URL` — WeMineOffice test URL.
- `WEMINEOFFICE_HOME_MARKER` — stable text visible after successful web sign-in.
- `WEMINE_EQUIPMENT_FORM_CODE` — test Form Code for a form configured in WeMineOffice and available to mobile.
- `WEMINE_TEST_REPORTER_NAME` — display name of the signed-in reporter used by the PIC-default case.
- `WEMINE_LOCATION`, `WEMINE_SUBLOCATION`, `WEMINE_AREA` — valid hazard master-data labels.
- `WEMINE_SECOND_LOCATION` — a second valid Location for location-selection checks.
- `WEMINE_CO_OBSERVER_1`, `WEMINE_CO_OBSERVER_2` — eligible employees used in follow-up cases.
- `WEMINE_WEB_FIELD_XPATH` — XPath matching form-field cards in the Form Builder; required for Form Builder tests.
- `WEMINE_WEB_RADIO_OPTION_XPATH` — XPath matching Radio option rows; required for Radio boundary tests.
- `WEMINE_SYNC_IN_PROGRESS_TEXT` — exact visible progress label used while master data is syncing.
- `WEMINE_ADD_CO_OBSERVER_LABEL` — accessibility label for the Co Observer (+) button if it is not exposed as `+`.
- `WEMINE_RESTART_PROMPT_TEXT` — visible text from the first-sync restart prompt, if the default word `restart` does not match.

Feature test cases assume the app is already signed in with the required test role unless the case is specifically testing sign-in. Use dedicated test accounts only. Do not put real user passwords in the project or test data files.

## Before running

The product brief does not include a live URL, APK, actual UI selectors, exact error copy, API response schema, or test credentials. Check the locators with Katalon Spy and replace generic text/XPath matches with stable IDs from the test build. Use a clean browser profile/device for first-sync cases. Network-interruption tests need a controllable test connection. Notification cases require test users for the reporter, PIC, people assigned to the area, and direct supervisor.

The web sync test checks browser resource timing for `/user/me` and `/tenant/master`; confirm those calls are visible in the target browser and that the application does not hide them from Resource Timing. The web offline test currently checks cached-page availability only, not an offline write queue.

## Product scope decisions

- Flow 0 is tested separately on mobile and web.
- Form Builder is tested on WeMineOffice Web.
- Safety Hazard and follow-up are tested on WeMine Mobile.
- Equipment Inspection is covered as a web-to-mobile workflow. An Equipment Inspection offline queue case is not included because offline submission/sync behavior for that flow is not explicitly defined. The separate mobile hazard offline case remains in scope.
- No Order workflow is included because the brief does not describe an Order flow.
