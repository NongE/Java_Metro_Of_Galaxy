package com.levelup.mog.model.dto;

import java.util.List;

public class SubwayUser {

    CardSubwayTime CardSubwayTime;

    static class CardSubwayTime{
        private Integer list_total_count;
        private Result RESULT;
        private List<Row> row;

        public Integer getList_total_count() {
            return list_total_count;
        }

        public void setList_total_count(Integer list_total_count) {
            this.list_total_count = list_total_count;
        }

        public Result getRESULT() {
            return RESULT;
        }

        public void setRESULT(Result RESULT) {
            this.RESULT = RESULT;
        }

        public List<Row> getRow() {
            return row;
        }

        public void setRow(List<Row> row) {
            this.row = row;
        }
    }

    static class Result{
        private String code;
        private String Message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return Message;
        }

        public void setMessage(String message) {
            Message = message;
        }
    }

    static class Row{

        private String USE_MON;
        private String LINE_NUM;
        private String SUB_STA_NM;
        private String FOUR_RIDE_NUM;
        private String FOUR_ALIGHT_NUM;
        private String FIVE_RIDE_NUM;
        private String FIVE_ALIGHT_NUM;
        private String SIX_RIDE_NUM;
        private String SIX_ALIGHT_NUM;
        private String SEVEN_RIDE_NUM;
        private String SEVEN_ALIGHT_NUM;
        private String EIGHT_RIDE_NUM;
        private String EIGHT_ALIGHT_NUM;
        private String NINE_RIDE_NUM;
        private String NINE_ALIGHT_NUM;
        private String TEN_RIDE_NUM;
        private String TEN_ALIGHT_NUM;
        private String ELEVEN_RIDE_NUM;
        private String ELEVEN_ALIGHT_NUM;
        private String TWELVE_RIDE_NUM;
        private String TWELVE_ALIGHT_NUM;
        private String THIRTEEN_RIDE_NUM;
        private String THIRTEEN_ALIGHT_NUM;
        private String FOURTEEN_RIDE_NUM;
        private String FOURTEEN_ALIGHT_NUM;
        private String FIFTEEN_RIDE_NUM;
        private String FIFTEEN_ALIGHT_NUM;
        private String SIXTEEN_RIDE_NUM;
        private String SIXTEEN_ALIGHT_NUM;
        private String SEVENTEEN_RIDE_NUM;
        private String SEVENTEEN_ALIGHT_NUM;
        private String EIGHTEEN_RIDE_NUM;
        private String EIGHTEEN_ALIGHT_NUM;
        private String NINETEEN_RIDE_NUM;
        private String NINETEEN_ALIGHT_NUM;
        private String TWENTY_RIDE_NUM;
        private String TWENTY_ALIGHT_NUM;
        private String TWENTY_ONE_RIDE_NUM;
        private String TWENTY_ONE_ALIGHT_NUM;
        private String TWENTY_TWO_RIDE_NUM;
        private String TWENTY_TWO_ALIGHT_NUM;
        private String TWENTY_THREE_RIDE_NUM;
        private String TWENTY_THREE_ALIGHT_NUM;

        private String MIDNIGHT_RIDE_NUM;
        private String MIDNIGHT_ALIGHT_NUM;
        private String ONE_RIDE_NUM;
        private String ONE_ALIGHT_NUM;
        private String TWO_RIDE_NUM;
        private String TWO_ALIGHT_NUM;
        private String THREE_RIDE_NUM;
        private String THREE_ALIGHT_NUM;
        private String WORK_DT;


        public String getUSE_MON() {
            return USE_MON;
        }

        public void setUSE_MON(String USE_MON) {
            this.USE_MON = USE_MON;
        }

        public String getLINE_NUM() {
            return LINE_NUM;
        }

        public void setLINE_NUM(String LINE_NUM) {
            this.LINE_NUM = LINE_NUM;
        }

        public String getSUB_STA_NM() {
            return SUB_STA_NM;
        }

        public void setSUB_STA_NM(String SUB_STA_NM) {
            this.SUB_STA_NM = SUB_STA_NM;
        }

        public String getFOUR_RIDE_NUM() {
            return FOUR_RIDE_NUM;
        }

        public void setFOUR_RIDE_NUM(String FOUR_RIDE_NUM) {
            this.FOUR_RIDE_NUM = FOUR_RIDE_NUM;
        }

        public String getFOUR_ALIGHT_NUM() {
            return FOUR_ALIGHT_NUM;
        }

        public void setFOUR_ALIGHT_NUM(String FOUR_ALIGHT_NUM) {
            this.FOUR_ALIGHT_NUM = FOUR_ALIGHT_NUM;
        }

        public String getFIVE_RIDE_NUM() {
            return FIVE_RIDE_NUM;
        }

        public void setFIVE_RIDE_NUM(String FIVE_RIDE_NUM) {
            this.FIVE_RIDE_NUM = FIVE_RIDE_NUM;
        }

        public String getFIVE_ALIGHT_NUM() {
            return FIVE_ALIGHT_NUM;
        }

        public void setFIVE_ALIGHT_NUM(String FIVE_ALIGHT_NUM) {
            this.FIVE_ALIGHT_NUM = FIVE_ALIGHT_NUM;
        }

        public String getSIX_RIDE_NUM() {
            return SIX_RIDE_NUM;
        }

        public void setSIX_RIDE_NUM(String SIX_RIDE_NUM) {
            this.SIX_RIDE_NUM = SIX_RIDE_NUM;
        }

        public String getSIX_ALIGHT_NUM() {
            return SIX_ALIGHT_NUM;
        }

        public void setSIX_ALIGHT_NUM(String SIX_ALIGHT_NUM) {
            this.SIX_ALIGHT_NUM = SIX_ALIGHT_NUM;
        }

        public String getSEVEN_RIDE_NUM() {
            return SEVEN_RIDE_NUM;
        }

        public void setSEVEN_RIDE_NUM(String SEVEN_RIDE_NUM) {
            this.SEVEN_RIDE_NUM = SEVEN_RIDE_NUM;
        }

        public String getSEVEN_ALIGHT_NUM() {
            return SEVEN_ALIGHT_NUM;
        }

        public void setSEVEN_ALIGHT_NUM(String SEVEN_ALIGHT_NUM) {
            this.SEVEN_ALIGHT_NUM = SEVEN_ALIGHT_NUM;
        }

        public String getEIGHT_RIDE_NUM() {
            return EIGHT_RIDE_NUM;
        }

        public void setEIGHT_RIDE_NUM(String EIGHT_RIDE_NUM) {
            this.EIGHT_RIDE_NUM = EIGHT_RIDE_NUM;
        }

        public String getEIGHT_ALIGHT_NUM() {
            return EIGHT_ALIGHT_NUM;
        }

        public void setEIGHT_ALIGHT_NUM(String EIGHT_ALIGHT_NUM) {
            this.EIGHT_ALIGHT_NUM = EIGHT_ALIGHT_NUM;
        }

        public String getNINE_RIDE_NUM() {
            return NINE_RIDE_NUM;
        }

        public void setNINE_RIDE_NUM(String NINE_RIDE_NUM) {
            this.NINE_RIDE_NUM = NINE_RIDE_NUM;
        }

        public String getNINE_ALIGHT_NUM() {
            return NINE_ALIGHT_NUM;
        }

        public void setNINE_ALIGHT_NUM(String NINE_ALIGHT_NUM) {
            this.NINE_ALIGHT_NUM = NINE_ALIGHT_NUM;
        }

        public String getTEN_RIDE_NUM() {
            return TEN_RIDE_NUM;
        }

        public void setTEN_RIDE_NUM(String TEN_RIDE_NUM) {
            this.TEN_RIDE_NUM = TEN_RIDE_NUM;
        }

        public String getTEN_ALIGHT_NUM() {
            return TEN_ALIGHT_NUM;
        }

        public void setTEN_ALIGHT_NUM(String TEN_ALIGHT_NUM) {
            this.TEN_ALIGHT_NUM = TEN_ALIGHT_NUM;
        }

        public String getELEVEN_RIDE_NUM() {
            return ELEVEN_RIDE_NUM;
        }

        public void setELEVEN_RIDE_NUM(String ELEVEN_RIDE_NUM) {
            this.ELEVEN_RIDE_NUM = ELEVEN_RIDE_NUM;
        }

        public String getELEVEN_ALIGHT_NUM() {
            return ELEVEN_ALIGHT_NUM;
        }

        public void setELEVEN_ALIGHT_NUM(String ELEVEN_ALIGHT_NUM) {
            this.ELEVEN_ALIGHT_NUM = ELEVEN_ALIGHT_NUM;
        }

        public String getTWELVE_RIDE_NUM() {
            return TWELVE_RIDE_NUM;
        }

        public void setTWELVE_RIDE_NUM(String TWELVE_RIDE_NUM) {
            this.TWELVE_RIDE_NUM = TWELVE_RIDE_NUM;
        }

        public String getTWELVE_ALIGHT_NUM() {
            return TWELVE_ALIGHT_NUM;
        }

        public void setTWELVE_ALIGHT_NUM(String TWELVE_ALIGHT_NUM) {
            this.TWELVE_ALIGHT_NUM = TWELVE_ALIGHT_NUM;
        }

        public String getTHIRTEEN_RIDE_NUM() {
            return THIRTEEN_RIDE_NUM;
        }

        public void setTHIRTEEN_RIDE_NUM(String THIRTEEN_RIDE_NUM) {
            this.THIRTEEN_RIDE_NUM = THIRTEEN_RIDE_NUM;
        }

        public String getTHIRTEEN_ALIGHT_NUM() {
            return THIRTEEN_ALIGHT_NUM;
        }

        public void setTHIRTEEN_ALIGHT_NUM(String THIRTEEN_ALIGHT_NUM) {
            this.THIRTEEN_ALIGHT_NUM = THIRTEEN_ALIGHT_NUM;
        }

        public String getFOURTEEN_RIDE_NUM() {
            return FOURTEEN_RIDE_NUM;
        }

        public void setFOURTEEN_RIDE_NUM(String FOURTEEN_RIDE_NUM) {
            this.FOURTEEN_RIDE_NUM = FOURTEEN_RIDE_NUM;
        }

        public String getFOURTEEN_ALIGHT_NUM() {
            return FOURTEEN_ALIGHT_NUM;
        }

        public void setFOURTEEN_ALIGHT_NUM(String FOURTEEN_ALIGHT_NUM) {
            this.FOURTEEN_ALIGHT_NUM = FOURTEEN_ALIGHT_NUM;
        }

        public String getFIFTEEN_RIDE_NUM() {
            return FIFTEEN_RIDE_NUM;
        }

        public void setFIFTEEN_RIDE_NUM(String FIFTEEN_RIDE_NUM) {
            this.FIFTEEN_RIDE_NUM = FIFTEEN_RIDE_NUM;
        }

        public String getFIFTEEN_ALIGHT_NUM() {
            return FIFTEEN_ALIGHT_NUM;
        }

        public void setFIFTEEN_ALIGHT_NUM(String FIFTEEN_ALIGHT_NUM) {
            this.FIFTEEN_ALIGHT_NUM = FIFTEEN_ALIGHT_NUM;
        }

        public String getSIXTEEN_RIDE_NUM() {
            return SIXTEEN_RIDE_NUM;
        }

        public void setSIXTEEN_RIDE_NUM(String SIXTEEN_RIDE_NUM) {
            this.SIXTEEN_RIDE_NUM = SIXTEEN_RIDE_NUM;
        }

        public String getSIXTEEN_ALIGHT_NUM() {
            return SIXTEEN_ALIGHT_NUM;
        }

        public void setSIXTEEN_ALIGHT_NUM(String SIXTEEN_ALIGHT_NUM) {
            this.SIXTEEN_ALIGHT_NUM = SIXTEEN_ALIGHT_NUM;
        }

        public String getSEVENTEEN_RIDE_NUM() {
            return SEVENTEEN_RIDE_NUM;
        }

        public void setSEVENTEEN_RIDE_NUM(String SEVENTEEN_RIDE_NUM) {
            this.SEVENTEEN_RIDE_NUM = SEVENTEEN_RIDE_NUM;
        }

        public String getSEVENTEEN_ALIGHT_NUM() {
            return SEVENTEEN_ALIGHT_NUM;
        }

        public void setSEVENTEEN_ALIGHT_NUM(String SEVENTEEN_ALIGHT_NUM) {
            this.SEVENTEEN_ALIGHT_NUM = SEVENTEEN_ALIGHT_NUM;
        }

        public String getEIGHTEEN_RIDE_NUM() {
            return EIGHTEEN_RIDE_NUM;
        }

        public void setEIGHTEEN_RIDE_NUM(String EIGHTEEN_RIDE_NUM) {
            this.EIGHTEEN_RIDE_NUM = EIGHTEEN_RIDE_NUM;
        }

        public String getEIGHTEEN_ALIGHT_NUM() {
            return EIGHTEEN_ALIGHT_NUM;
        }

        public void setEIGHTEEN_ALIGHT_NUM(String EIGHTEEN_ALIGHT_NUM) {
            this.EIGHTEEN_ALIGHT_NUM = EIGHTEEN_ALIGHT_NUM;
        }

        public String getNINETEEN_RIDE_NUM() {
            return NINETEEN_RIDE_NUM;
        }

        public void setNINETEEN_RIDE_NUM(String NINETEEN_RIDE_NUM) {
            this.NINETEEN_RIDE_NUM = NINETEEN_RIDE_NUM;
        }

        public String getNINETEEN_ALIGHT_NUM() {
            return NINETEEN_ALIGHT_NUM;
        }

        public void setNINETEEN_ALIGHT_NUM(String NINETEEN_ALIGHT_NUM) {
            this.NINETEEN_ALIGHT_NUM = NINETEEN_ALIGHT_NUM;
        }

        public String getTWENTY_RIDE_NUM() {
            return TWENTY_RIDE_NUM;
        }

        public void setTWENTY_RIDE_NUM(String TWENTY_RIDE_NUM) {
            this.TWENTY_RIDE_NUM = TWENTY_RIDE_NUM;
        }

        public String getTWENTY_ALIGHT_NUM() {
            return TWENTY_ALIGHT_NUM;
        }

        public void setTWENTY_ALIGHT_NUM(String TWENTY_ALIGHT_NUM) {
            this.TWENTY_ALIGHT_NUM = TWENTY_ALIGHT_NUM;
        }

        public String getTWENTY_ONE_RIDE_NUM() {
            return TWENTY_ONE_RIDE_NUM;
        }

        public void setTWENTY_ONE_RIDE_NUM(String TWENTY_ONE_RIDE_NUM) {
            this.TWENTY_ONE_RIDE_NUM = TWENTY_ONE_RIDE_NUM;
        }

        public String getTWENTY_ONE_ALIGHT_NUM() {
            return TWENTY_ONE_ALIGHT_NUM;
        }

        public void setTWENTY_ONE_ALIGHT_NUM(String TWENTY_ONE_ALIGHT_NUM) {
            this.TWENTY_ONE_ALIGHT_NUM = TWENTY_ONE_ALIGHT_NUM;
        }

        public String getTWENTY_TWO_RIDE_NUM() {
            return TWENTY_TWO_RIDE_NUM;
        }

        public void setTWENTY_TWO_RIDE_NUM(String TWENTY_TWO_RIDE_NUM) {
            this.TWENTY_TWO_RIDE_NUM = TWENTY_TWO_RIDE_NUM;
        }

        public String getTWENTY_TWO_ALIGHT_NUM() {
            return TWENTY_TWO_ALIGHT_NUM;
        }

        public void setTWENTY_TWO_ALIGHT_NUM(String TWENTY_TWO_ALIGHT_NUM) {
            this.TWENTY_TWO_ALIGHT_NUM = TWENTY_TWO_ALIGHT_NUM;
        }

        public String getTWENTY_THREE_RIDE_NUM() {
            return TWENTY_THREE_RIDE_NUM;
        }

        public void setTWENTY_THREE_RIDE_NUM(String TWENTY_THREE_RIDE_NUM) {
            this.TWENTY_THREE_RIDE_NUM = TWENTY_THREE_RIDE_NUM;
        }

        public String getTWENTY_THREE_ALIGHT_NUM() {
            return TWENTY_THREE_ALIGHT_NUM;
        }

        public void setTWENTY_THREE_ALIGHT_NUM(String TWENTY_THREE_ALIGHT_NUM) {
            this.TWENTY_THREE_ALIGHT_NUM = TWENTY_THREE_ALIGHT_NUM;
        }

        public String getMIDNIGHT_RIDE_NUM() {
            return MIDNIGHT_RIDE_NUM;
        }

        public void setMIDNIGHT_RIDE_NUM(String MIDNIGHT_RIDE_NUM) {
            this.MIDNIGHT_RIDE_NUM = MIDNIGHT_RIDE_NUM;
        }

        public String getMIDNIGHT_ALIGHT_NUM() {
            return MIDNIGHT_ALIGHT_NUM;
        }

        public void setMIDNIGHT_ALIGHT_NUM(String MIDNIGHT_ALIGHT_NUM) {
            this.MIDNIGHT_ALIGHT_NUM = MIDNIGHT_ALIGHT_NUM;
        }

        public String getONE_RIDE_NUM() {
            return ONE_RIDE_NUM;
        }

        public void setONE_RIDE_NUM(String ONE_RIDE_NUM) {
            this.ONE_RIDE_NUM = ONE_RIDE_NUM;
        }

        public String getONE_ALIGHT_NUM() {
            return ONE_ALIGHT_NUM;
        }

        public void setONE_ALIGHT_NUM(String ONE_ALIGHT_NUM) {
            this.ONE_ALIGHT_NUM = ONE_ALIGHT_NUM;
        }

        public String getTWO_RIDE_NUM() {
            return TWO_RIDE_NUM;
        }

        public void setTWO_RIDE_NUM(String TWO_RIDE_NUM) {
            this.TWO_RIDE_NUM = TWO_RIDE_NUM;
        }

        public String getTWO_ALIGHT_NUM() {
            return TWO_ALIGHT_NUM;
        }

        public void setTWO_ALIGHT_NUM(String TWO_ALIGHT_NUM) {
            this.TWO_ALIGHT_NUM = TWO_ALIGHT_NUM;
        }

        public String getTHREE_RIDE_NUM() {
            return THREE_RIDE_NUM;
        }

        public void setTHREE_RIDE_NUM(String THREE_RIDE_NUM) {
            this.THREE_RIDE_NUM = THREE_RIDE_NUM;
        }

        public String getTHREE_ALIGHT_NUM() {
            return THREE_ALIGHT_NUM;
        }

        public void setTHREE_ALIGHT_NUM(String THREE_ALIGHT_NUM) {
            this.THREE_ALIGHT_NUM = THREE_ALIGHT_NUM;
        }

        public String getWORK_DT() {
            return WORK_DT;
        }

        public void setWORK_DT(String WORK_DT) {
            this.WORK_DT = WORK_DT;
        }
    }
}
