function Question(text, choices, answer){
    this.answer=answer;
    this.text=text;
    this.choices=choices;
}

function Quiz(questions){
    this.score=0;
    this.questions=questions;
    this.questionIndex=0;
}

Quiz.prototype.getCurrentQuestion= function() {
    return this.questions[this.questionIndex];
}

Quiz.prototype.checkOptionWithAnswer =function(choice) {
    var ques = envQuiz.getCurrentQuestion();
    if(ques.isCorrectAnswer(choice)){
        envQuiz.score++;
    }
    envQuiz.questionIndex++;
}


Quiz.prototype.isEnded =function() {
    return envQuiz.questionIndex===envQuiz.questions.length;
}

Question.prototype.isCorrectAnswer= function(choice){
    return this.answer===choice;
}


var questions=[
    new Question 
("1) Why do we recycle?",
["To get along our family",
"To be successful at our school",
"To protect our environment and benefit our future",
"To move freely outside"],
"To protect our environment and benefit our future"),

new Question
("2) When is the World Water Day?",
["13<sup>th</sup> May",
"29<sup>th</sup> August",
"22<sup>nd</sup> March",
"13<sup>th</sup> September"],"22<sup>nd</sup> March"),

new Question
("3) Why do we use 'postermywall' for?",
["To prepare poster",
"To prepare games",
"To make jokes",
"To be healthy"],"To prepare poster"
),

new Question
("4) When is the World Environment Day?",
["05<sup>th</sup> June",
"14<sup>th</sup> Oct",
"31<sup>th</sup> Feb",
"19<sup>th</sup> Jan"],
"05<sup>th</sup> June"),

new Question
("5) When is World Pollution Prevention Day?",
["1<sup>st</sup> Jan",
"30<sup>th</sup> May",
"30<sup>th</sup> Sep",
"02<sup>nd</sup> Dec"
],
"02<sup>nd</sup> Dec"),

new Question
("6) When is world health day?",
["1<sup>st</sup> Apr",
"7<sup>th</sup> Apr",
"10<sup>th</sup> Apr",
"30<sup>th</sup> Apr"],"7<sup>th</sup> Apr")
];

let envQuiz= new Quiz(questions);

console.log(questions);

function loadQuestions(){
    if(envQuiz.isEnded()){        
        document.getElementById("quiz")
        .innerHTML
        ="<h1>Javascript Quiz</h1> <hr style='margin-bottom: 20px'><h2>Your Score is "+envQuiz.score+"</h2>";
    }else{
        let ques = envQuiz.getCurrentQuestion();
        document.getElementById("question").innerHTML=ques.text;

        var choices=ques.choices;
        console.log(choices);
        for(let q=0;q<choices.length;q++){
            console.log(choices[q]);
            document.getElementById("choice"+q).innerHTML=choices[q];
            handleOptionButton("btn"+q,ques.choices[q]);
        }
        showProgressBar();
    }
}

function handleOptionButton(btnNo,choice){
    let btn = document.getElementById(btnNo);
    btn.onclick=function(){
        envQuiz.checkOptionWithAnswer(choice);
        loadQuestions();
    }
}
loadQuestions();

function showProgressBar(){
    document.getElementById("progress").innerHTML="Question "+(envQuiz.questionIndex+1)+" of "+questions.length;
}
