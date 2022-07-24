// Copied from a utility file of the same name in Greenroom
function randomString(length: number, chars: string) {
	var result = '';
	for (var i = length; i > 0; --i)
		result += chars[Math.floor(Math.random() * chars.length)];
	return result;
}

export const random = (len: number) => {
	return randomString(
		len,
		'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ',
	);
};
