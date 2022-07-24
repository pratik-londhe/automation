import {createPool} from "mysql"

const pool = createPool({
    //@ts-ignore
    host: browser.config.MySql_DB_Server,
    //@ts-ignore
    port: browser.config.MySql_DB_Port,
    //@ts-ignore
    database: browser.config.MySql_DB_Name,
    //@ts-ignore
    user: browser.config.MySql_DB_User,
    //@ts-ignore
    password: browser.config.MySql_DB_Password,
    connectionLimit: 10
})


let getMySqlQueryResult = function(query) {
	return new Promise(function(resolve, reject) {
		pool.query(query, (err,result)=>{
			if(!err) {
				resolve(result);
			} else {
				console.log(`${err.message}`)
				reject(Error("Query issue"));
			}
		})
	});
}

export {getMySqlQueryResult}

