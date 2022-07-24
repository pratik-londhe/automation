import {Client} from "pg"

const client = new Client({
    //@ts-ignore
    host: browser.config.PG_DB_Server,
    //@ts-ignore
    port: browser.config.PG_DB_Port,
    //@ts-ignore
    databse: browser.config.PG_DB_Name,
    //@ts-ignore
    user: browser.config.PG_DB_User,
    //@ts-ignore
    password: browser.config.PG_DB_Password
})

async function getPgQueryResult(query: string): Promise<any> {
    client.connect()
    client.query(query, (err,result)=>{
        if(!err) {
            console.log(`>> Query Result: ${result.rows}`)
            return result.rows
        } else {
            console.log(`${err.message}`)
        }
        client.end
    })
}

export {getPgQueryResult}