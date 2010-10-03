package org.lifeforachild.web.ajax;

import java.text.DecimalFormat;

import org.lifeforachild.domain.ClinicalRecord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/ajax/bmi/*/*")
@Controller
public class BmiController
{
    @RequestMapping("/ajax/bmi/{weightKG}/{heightCM}")
    public @ResponseBody String calculateWeightSD(@PathVariable String weightKG, @PathVariable String heightCM)
    {
        try
        {
            Float weightKGValue = Float.parseFloat(weightKG);
            Float heightCMValue = Float.parseFloat(heightCM);

            return new DecimalFormat("0.##").format(ClinicalRecord.calculateBMI(weightKGValue, heightCMValue));
        }
        catch (NumberFormatException e)
        {
            return e.getMessage();
        }
    }
}
