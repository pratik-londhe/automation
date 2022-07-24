import CryptoJS from "crypto-js"

class CloudflareParameters {

    expiry: number
    mac: string
    readonly secret = "Wp4RYjW0bg/pzkoz6sx/yhmw3FFeKcUMk74za2oVpeI"

    constructor(){

    }

    async generateCloudflareParameters(path: string) {

        this.expiry = Date.now() + 60000; 
        console.log(`The expiry is: ${this.expiry}`)
            
        const data = `${path}${this.expiry}`
        const hmac = CryptoJS.algo.HMAC.create(CryptoJS.algo.SHA256, this.secret)
        hmac.update(data)
        const actualSiganture = hmac.finalize()
    
        const base64 = CryptoJS.enc.Base64.stringify(actualSiganture)
        this.mac = encodeURIComponent(base64)

        console.log(`The mac is: ${this.mac}`)
    }

}
export default new CloudflareParameters

// async function getCloudflareParameters(path: string) {

//     let expiry: number
//     let mac: string
//     const secret = "Wp4RYjW0bg/pzkoz6sx/yhmw3FFeKcUMk74za2oVpeI"
//     let parameters = []

//     expiry = Date.now() + 60000
//     console.log(`The expiry is: ${expiry}`)

//     const data = `${path}${this.expiry}`
//     const hmac = CryptoJS.algo.HMAC.create(CryptoJS.algo.SHA256, secret)
//     hmac.update(data)
//     const actualSiganture = hmac.finalize()
//     //console.log(`Signature >>> ${actualSiganture}`);

//     const base64 = CryptoJS.enc.Base64.stringify(actualSiganture)
//     mac = encodeURIComponent(base64)
//     console.log(`The mac is: ${mac}`)
//     parameters.push(mac)
//     parameters.push(expiry)

//     return parameters
// }
// export default { getCloudflareParameters }