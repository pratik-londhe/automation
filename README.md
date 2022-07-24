# bl-js-bdd-test
Make sure you have node installed locally.

Please checkout this project and run the command `npm install`. 

# How to run locally on docker
1. Start Docker
docker-compose up

2. Update BROWSER to be DOCKER and wdio to be config/wdio.load-test.conf.ts

```
   "qa:firefox:ui:standaloneGRLoadTesting:dummy_user_3": "export DEBUG=Y && export HEADLESS=N && export BROWSER=DOCKER && npx wdio config/wdio.load-test.conf.ts --cucumberOpts.tagExpression='@dummy_user_3'",
```

3. When running NPM

```
   SELENIUM_GRID_HOST=localhost \
   SELENIUM_GRID_PORT=4444 \
   ROOM_CODE=code_here \
   npm run qa:firefox:ui:standaloneGRLoadTesting:dummy_user_3
```

   Then if you only want one browser like chrome you'll have to comment out lines 203 - 227 in wdio.conf.ts

```
   // {
   //     // maxInstances can get overwritten per capability. So if you have an in-house Selenium
   //     // grid with only 5 firefox instances available you can make sure that not more than
   //     // 5 instances get started at a time.
   //     maxInstances: 5,
   //     //
   //     browserName: 'firefox',
   //     //path: '/wd/hub',
   //     "moz:firefoxOptions": {
   //         args: headless.toUpperCase() === "Y" ? ["-headless", "-disable-dev-shm-usage", "-no-sandbox"] : ["-width=1920", "-height=1080"],
   //         prefs: {
   //             "permissions.default.notifications": 1,
   //             "permissions.default.geolocation": 1,
   //             "permissions.default.microphone": 1,
   //             "permissions.default.camera": 1,
   //             "media.navigator.streams.fake": true
   //         }
   //     },
   //     acceptInsecureCerts: true,
   //     timeouts: {implicit: 5000, pageLoad: 20000, script: 30000}
   //     // If outputDir is provided WebdriverIO can capture driver session logs
   //     // it is possible to configure which logTypes to include/exclude.
   //     // excludeDriverLogs: ['*'], // pass '*' to exclude all driver session logs
   //     // excludeDriverLogs: ['bugreport', 'server'],
   // }
```
