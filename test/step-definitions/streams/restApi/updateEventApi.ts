import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import CreateEventRestApi from "../../../page-objects/streams/restApi/createEventRestApi"
import PeopleRestApi from "../../../page-objects/streams/restApi/peopleRestApi"
import ChannelRestApi from "../../../page-objects/streams/restApi/channelRestApi"
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"
import UpdateEventRestApi from "../../../page-objects/streams/restApi/updateEventRestApi"
import fs from "fs"
import { createEventJsonFile } from "./createEventApi";

Given (/^An event with sessions exists$/, async function(){
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;

    let getEvents = Object.getPrototypeOf(HomeRestApi).constructor.getEventsForChannelRes;

    const matchingItem = getEvents.find((event: any) => {
        return event.sessions !== [];
    })
      
    console.log(JSON.parse(JSON.stringify(matchingItem)));
    chai.assert(matchingItem.sessions !== [], "Event with sessions found");

    const eventUuid = matchingItem.uuid;
    
    const eventDetails = await CreateEventRestApi.getEventDetailsByUuid(host, eventUuid);
    chai.assert(eventDetails.uuid === eventUuid);

})

When(/^An event is updated with the passcode list$/, async function() {
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;

    let eventDetails = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes;
    const passCodeList = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListEmailAndPassRes;

    //@ts-ignore
    const gatedSession = eventDetails.sessions[0].session;

    eventDetails.registration_settings.requirements = {
        "3": [
            {
            "gatedSessions": [
                gatedSession
            ],
            "type": passCodeList.type,
            "passcodeList": [
                passCodeList.passcode_list
            ]
            }
        ]
    }

    eventDetails.registration_on = true;

    eventDetails.registration_steps = [
        {
          "type": "general",
          "isOn": true,
          "questions": [
            {
              "registration_question": 1,
              "channel": 0,
              "name": "First Name",
              "type": "text",
              "options": null,
              "global": true,
              "persistent": true,
              "default_value": null,
              "placeholder": null,
              "name_translation": null,
              "options_translation": null
            },
            {
              "registration_question": 2,
              "channel": 0,
              "name": "Last Name",
              "type": "text",
              "options": null,
              "global": true,
              "persistent": true,
              "default_value": null,
              "placeholder": null,
              "name_translation": null,
              "options_translation": null
            },
            {
              "registration_question": 3,
              "channel": 0,
              "name": "Email Address",
              "type": "email",
              "options": null,
              "global": true,
              "persistent": true,
              "default_value": null,
              "placeholder": null,
              "name_translation": null,
              "options_translation": null
            },
            {
              "registration_question": 10,
              "channel": 0,
              "name": "Passcode",
              "type": "text",
              "options": null,
              "global": true,
              "persistent": false,
              "default_value": null,
              "placeholder": null,
              "name_translation": null,
              "options_translation": null
            }
          ]
        },
        {
          "type": "profile",
          "isOn": false,
          "questions": [
            {
              "registration_question": 6,
              "channel": 0,
              "name": "Company Name",
              "type": "text",
              "options": null,
              "global": true,
              "persistent": true,
              "default_value": null
            },
            {
              "registration_question": 4,
              "channel": 0,
              "name": "Bio",
              "type": "text",
              "options": null,
              "global": true,
              "persistent": false,
              "default_value": null
            },
            {
              "registration_question": 9,
              "channel": 0,
              "name": "Fun Fact",
              "type": "text",
              "options": null,
              "global": true,
              "persistent": false,
              "default_value": null
            }
          ]
        },
        {
          "type": "avatar",
          "isOn": false
        }
      ]

      eventDetails = { event: eventDetails};
      const updateEvent = await UpdateEventRestApi.updateEvent(host, eventDetails);
      chai.assert(updateEvent.status === 200, `Request Successful - ${updateEvent.status}`);

      const getEvent = await CreateEventRestApi.getEventDetailsByUuid(host, eventDetails.event.uuid);
      chai.assert(getEvent.uuid === eventDetails.event.uuid);
})

Then (/^The passcode list will be verifed as added to event$/, async function() {
    //@ts-ignore
    let channelName = browser.config.ChannelName;
    console.log(`Validating channel name: ${channelName}`);
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;

    const eventDetails = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes;
    const passCodeList = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListEmailAndPassRes;
    //@ts-ignore
    chai.assert(eventDetails.registration_settings.requirements["3"][0].passcodeList == passCodeList.passcode_list, 
    `Passcode List ${eventDetails.registration_settings.requirements["3"][0].passcodeList} was successfully added to Event ${eventDetails.event}`);
})

Given (/^Update the event with the ticket info$/, async function(){
  //@ts-ignore
  const host = browser.config.Streams_Api_Host;

  let eventDetails = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes;
  
  let eventInfoDetails = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes;
    
  let sessionsArr = eventInfoDetails.sessions;
  let sesssionsIDArr = [];
  let sessionsUUIDArr = [];

  sessionsArr.forEach(element => {
      sesssionsIDArr.push(element.session);
      sessionsUUIDArr.push(element.uuid);
  });

  eventDetails.registration_steps = [
    {
      "type": "general",
      "isOn": true,
      "questions": [
        {
          "registration_question": 1,
          "channel": 0,
          "name": "First Name",
          "type": "text",
          "options": null,
          "global": true,
          "persistent": true,
          "default_value": null,
          "placeholder": null,
          "name_translation": null,
          "options_translation": null
        },
        {
          "registration_question": 2,
          "channel": 0,
          "name": "Last Name",
          "type": "text",
          "options": null,
          "global": true,
          "persistent": true,
          "default_value": null,
          "placeholder": null,
          "name_translation": null,
          "options_translation": null
        },
        {
          "registration_question": 3,
          "channel": 0,
          "name": "Email Address",
          "type": "email",
          "options": null,
          "global": true,
          "persistent": true,
          "default_value": null,
          "placeholder": null,
          "name_translation": null,
          "options_translation": null
        },
        {
          "registration_question": 10,
          "channel": 0,
          "name": "Passcode",
          "type": "text",
          "options": null,
          "global": true,
          "persistent": false,
          "default_value": null,
          "placeholder": null,
          "name_translation": null,
          "options_translation": null
        }
      ]
    },
    {
      "type": "profile",
      "isOn": false,
      "questions": [
        {
          "registration_question": 6,
          "channel": 0,
          "name": "Company Name",
          "type": "text",
          "options": null,
          "global": true,
          "persistent": true,
          "default_value": null
        },
        {
          "registration_question": 4,
          "channel": 0,
          "name": "Bio",
          "type": "text",
          "options": null,
          "global": true,
          "persistent": false,
          "default_value": null
        },
        {
          "registration_question": 9,
          "channel": 0,
          "name": "Fun Fact",
          "type": "text",
          "options": null,
          "global": true,
          "persistent": false,
          "default_value": null
        }
      ]
    },
    {
      "type": "avatar",
      "isOn": false
    },
    {
      "isOn":true,
      "type":"ticketing",
      "ticketing":[
         {
            "name":"Regular Ticket",
            "prices":[
               {
                  "price":1,
                  "currency":"USD",
                  "multiplier":100
               }
            ],
            "quantity":10,
            "uuid":"81727e9a-ebcc-40cb-8bd4-db151ce446e4",
            "sessions":sesssionsIDArr,
            "session_uuids":sessionsUUIDArr
         }
      ]
   }
  ]

  eventDetails = { event: eventDetails};
  const updateEvent = await UpdateEventRestApi.updateEvent(host, eventDetails);
  chai.assert(updateEvent.status === 200, `Request Successful - ${updateEvent.status}`);
  chai.expect(updateEvent.text).to.equal('OK');
  await createEventJsonFile(eventDetails);
  reporter.addStep("info", `Update event with the ticket info... is success.`)
})
