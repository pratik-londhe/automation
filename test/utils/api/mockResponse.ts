export const getMockResponse = <T>(
	input: T,
	timeout: number,
): Promise<T> => {
	return new Promise((resolve) => {
		setTimeout(() => {
			resolve(input);
		}, timeout);
	});
};

export const getMockImageArray = (
	imagesEndpoint: string,
	filename: string,
	repeat: number,
) => {
	let retStr = '';

	for (let count = 0; count < repeat; count++) {
		retStr += `${imagesEndpoint}/${filename}-${count + 1}.jpg,`;
	}

	// Remove trailing `,`
	retStr = retStr.slice(0, -1);

	return retStr;
};
