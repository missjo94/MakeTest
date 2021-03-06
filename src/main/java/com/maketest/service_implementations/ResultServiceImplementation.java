<<<<<<< HEAD
package com.maketest.service_implementations;

import com.maketest.model.Result;
import com.maketest.repository.ResultRepository;
import com.maketest.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jovana Micic on 25-Oct-16.
 */
@Service
public class ResultServiceImplementation implements ResultService {

    @Autowired
    ResultRepository resultRepository;

    @Override
    public Result findOne(int id) {
        Result result = resultRepository.findOne(id);
        Result retVal = null;

        if (result!= null)
            retVal = result;
        else
            throw new IllegalArgumentException("There is no data with id: " + id);
        return retVal;
    }
}
=======
package com.maketest.service_implementations;

import com.maketest.dto.UserAnswerDTO;
import com.maketest.model.Answer;
import com.maketest.model.Question;
import com.maketest.model.Result;
import com.maketest.model.UserAnswer;
import com.maketest.repository.AnswerRepository;
import com.maketest.repository.ResultRepository;
import com.maketest.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Jovana Micic on 25-Oct-16.
 */
@Service
public class ResultServiceImplementation implements ResultService {

    @Autowired
    ResultRepository resultRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public Result findOne(int id) {
        return resultRepository.findOne(id);
    }

    @Override
    public Result save(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public int calculate(Set<UserAnswerDTO> userAnswers) {
        double percentage = 0;
        double correctAnswers = 0;
        double totalQuestions = userAnswers.size();

        for (UserAnswerDTO ua : userAnswers) {
            Answer ans = answerRepository.findOne(ua.getUserAnswer().getId());
            Question q = ans.getQuestionAnswers();
            if (ans.getAnswerText().equalsIgnoreCase(q.getCorrectAnswer())){
                correctAnswers++;
            }
        }
        if (correctAnswers > 0){
            percentage = (correctAnswers/totalQuestions) * 100;
        }
        return (int) percentage;
    }
}
>>>>>>> 3e8b4f6b46df55a25ab9a29a2fa68ddb13b105a5
