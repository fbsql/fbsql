/**
 * Custom notifier function
 *
 * @param eventJson
 * @param remoteInfoJson
 * @returns custom event object
 */
function notifier(eventJson, remoteInfoJson) {
//	java.lang.System.out.println('in notifier');
//	java.lang.System.out.println(JSON.stringify(eventJson, null, '\t'));
//	java.lang.System.out.println(JSON.stringify(remoteInfoJson, null, '\t'));
	return {eventJson: eventJson, remoteInfoJson: remoteInfoJson};
}

function a2bc(conn, k, t) {
	let reb = conn.getMetaData().getDatabaseProductName();
java.lang.System.out.println('zzzzzzzzzzzzzzzzzzzzzzzzzz='+reb);

	return [{ aaa: reb , bbb:"DFFF", ccc:45, eee:null, fff: true, rrr: k, sss: t }];
}
/**
 * Custom validator function
 *
 * @param eventJson
 * @returns undefined or null to accept execution or cusom reject object for execution reject
 */
function validator(eventJson) {
//	java.lang.System.out.println('in validator');
//	java.lang.System.out.println(JSON.stringify(eventJson, null, '\t'));
//	return {issuer: eventJson, remote: remoteInfoJson};
}

