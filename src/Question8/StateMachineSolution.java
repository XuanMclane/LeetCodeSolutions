package Question8;
//https://leetcode.com/problems/string-to-integer-atoi/solution/

enum State {q0, q1, q2, qd}

class StateMachine {
    private State currentState;

    private int result, sign;

    public StateMachine() {
        currentState = State.q0;
        result = 0;
        sign = 1;
    }

    private void toStateQ1(char c) {
        currentState = State.q1;
        sign = (c == '-') ? -1 : 1;
    }

    private void toStateQ2(int digit) {
        currentState = State.q2;
        appendDigit(digit);
    }

    private void toStateQd() {
        currentState = State.qd;
    }

    public int getFinalResult() {
        return result * sign;
    }

    private void appendDigit(int digit) {
        if ((result > Integer.MAX_VALUE /10) || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10)) {
            if (sign == 1) {
                result = Integer.MAX_VALUE;
            } else {
                result = Integer.MIN_VALUE;
                sign = 1;
            }
            toStateQd();
        } else {
            result = result * 10 + digit;
        }
    }

    public void transitState(char ch) {
        if (currentState == State.q0) {
            if (ch == '-' || ch == '+') {
                toStateQ1(ch);
            } else if (ch == ' ') {
                return;
            } else if (Character.isDigit(ch)) {
                int digit = ch - '0';
                toStateQ2(digit);
            } else {
                toStateQd();
            }
        } else if (currentState == State.q1 || currentState == State.q2) {
            if (Character.isDigit(ch)) {
                int digit = ch - '0';
                toStateQ2(digit);
            } else {
                toStateQd();
            }
        }
    }
}

public class StateMachineSolution {
    public int myAtoi(String input) {
        StateMachine sm = new StateMachine();

        for (int i = 0; i < input.length(); i++) {
            sm.transitState(input.charAt(i));
        }

        return sm.getFinalResult();
    }

    public static void main(String[] args) {
        StateMachineSolution sms = new StateMachineSolution();
        System.out.println(sms.myAtoi("42"));
    }
}
