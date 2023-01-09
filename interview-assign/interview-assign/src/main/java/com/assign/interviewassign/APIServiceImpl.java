package com.assign.interviewassign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APIServiceImpl implements APIService{
    @Autowired
    APIRepository apiRepository;
    @Override
    public boolean saveAPIEntry(APIEntity apiEntity) throws Exception{
        if(apiEntity == null)
            throw new Exception("Invalid Input");
        else {
            apiRepository.save(apiEntity);
            return true;
        }
    }
}
