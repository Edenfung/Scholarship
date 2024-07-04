const responseObj = {
  hello: "Hello ! How can I assist you today?",
  morning: "Hello ! How can I assist you today?",
  hey: "This is SEHS Hong Kong Tertiary Education. How can I assist you today?",
  today: new Date().toDateString(),
  time: new Date().toLocaleTimeString(),
  scholarship: "For year 2023-2024, the students could apply for three scholarships. ",
  HHB: "Our location of HHB campus is 8 Hung Lok Road, Hung Hom, Kowloon. ",
  WK: "Our location of WK campus is 9 Hoi Ting Road, Yau Ma Tei, Kowloon. ",
  parttime: "2024 Part-Time Student Scholarship is for outstanding parttime student with GPA 3.3 or above. For more details, please visit our website. "
};

const fetchResponse = (userInput) => {
  return new Promise((res, reject) => {
	try {
		setTimeout(() => {
			res(responseObj[userInput]);
		}, 800);
	} catch (error) {
		reject(error);
	}
  });
}

const chatBotService = {
  getBotResponse(userInput){
    return fetchResponse(userInput);
  },
}
export default chatBotService;
