$( document ).ready(function() {
    chatbot();
    scholarship();
    rejected();
});

function chatbot() {
	$(".chatbot").click(function(){
		$("iframe").slideToggle();
	})
}

function scholarship() {
	let scholarship = [
		["1", "2024 SEHS Scholarship"], 
		["2", "EC Outstanding Awards"], 
		["3", "2024 Part-Time Student Scholarship"]
	];
	
	const schoid = document.querySelectorAll(".scho");

	schoid.forEach(schoid => {
		const num = parseInt(schoid.textContent.trim()) - 1;
		
		if (scholarship[num])
			schoid.textContent = scholarship[num][1];
	});
}

function rejected() {
  let process = ["Approved", "Rejected", "Fund Full"];

  const approvals = document.querySelectorAll(".status");

  approvals.forEach(approval => {
    const p = approval.textContent.trim();

    if (process[0] == p) {
      $(approval).addClass("approve").removeClass("reject full");
    } else if (process[1] == p) {
      $(approval).addClass("reject").removeClass("approve full");
    } else if (process[2] == p) {
      $(approval).addClass("full").removeClass("approve reject");
    } else {
      $(approval).removeClass("approve reject full");
    }
  });
}