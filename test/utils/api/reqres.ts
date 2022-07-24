import request from "supertest"

class Reqres {

    static userDetailsByPageNumberRes: any
    static addNewUserRes: any

    constructor() {

    }

    async getUserDetailsByPageNumber(url: string, endpoint: string, query: string) {
        try{
            console.log(`>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>`)
            let res = await request(url)
                .get(endpoint)
                .query(query)
                .set("content-type", "application/json")
                .accept("application/json")

            console.log(`>> Response: ${JSON.stringify(res.body)}`)
            Reqres.userDetailsByPageNumberRes = JSON.parse(JSON.stringify(res.body))
            return Reqres.userDetailsByPageNumberRes;
        }catch(err){
            err.message = `The Get user details by page number: ${err.message}`
            throw err
        }
    }

    async postNewUser(payload: string, url: string, endpoint: string) {
        try{
            console.log(`>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>`)
            console.log(`The payload is >> ${payload}`)
            let res = await request(url)
                .post(endpoint)
                .set("content-type", "application/json")
                .accept("application/json")
                .send(payload)

            console.log(`>> Response: ${JSON.stringify(res.body)}`)
            Reqres.addNewUserRes = JSON.stringify(res.body)
            return Reqres.addNewUserRes;
        }catch(err){
            err.message = `The add new user: ${err.message}`
            throw err
        }
    }
}

export default new Reqres