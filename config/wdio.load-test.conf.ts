import {config as baseConfig} from "../wdio.conf"

const hostname = process.env.SELENIUM_GRID_HOST ?? 'localhost';
const port = process.env.SELENIUM_GRID_PORT ?? 80;
const path = process.env.SELENIUM_GRID_PATH ?? '/';
const server = process.env.GREENROOM_URL ?? 'https://greenroom.brandlive-qa.com';
const browserChoice = process.env.BROWSER_CHOICE ?? 'firefox'; // 'chrome'

const chromeBrowser = {
	maxInstances: 4,
	browserName: 'chrome',
	"goog:chromeOptions": {
		args: ["--use-fake-device-for-media-stream", "--window-size=1360,1020"],
		prefs: {
			"hardware.audio_capture_enabled": true,
			"hardware.video_capture_enabled": true,
			"hardware.audio_capture_allowed_urls": [server],
			"hardware.video_capture_allowed_urls": [server]
		}
	},
	acceptInsecureCerts: true,
	timeouts: {implicit: 5000, pageLoad: 20000, script: 30 * 60 * 1000},
}

const firefoxBrowser = {
	maxInstances: 4,
	browserName: 'firefox',
	"moz:firefoxOptions": {
		args: ["-width=1360", "-height=1020"],
		prefs: {
			"permissions.default.notifications": 1,
			"permissions.default.geolocation": 1,
			"permissions.default.microphone": 1,
			"permissions.default.camera": 1,
			"media.navigator.streams.fake": true
		}
	},
	acceptInsecureCerts: true,
	timeouts: {implicit: 5000, pageLoad: 20000, script: 30 * 60 * 1000}
}

export const config = Object.assign(baseConfig, {
	hostname,
	port: Number(port),
	path,
	Greenroom_Ui_Host: server,
	Password: "Brandlive123!",
	capabilities: [
		browserChoice === 'firefox'
			? firefoxBrowser
			: chromeBrowser
	],
});
