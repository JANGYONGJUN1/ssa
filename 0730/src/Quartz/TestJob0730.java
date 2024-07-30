package Quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob0730 implements Job {
	/**
	 * Job interface 구현체 Job의 trigger 실행 시 execute() Method는 scheduler의 스레드 중 하나에 의해
	 * 호출
	 *
	 * @param JobExecutionContext 런타임 환경에 대한 정보, 이 환경을 실행한 Scheduler에 대한 핸들, 실행을
	 *                            트리거한 트리거에 대한 핸들, 작업의 JobDetail 개체 및 기
	 */
	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException {

		long nowTime = System.currentTimeMillis();
		System.out.println("Job가 실행됨 : 5명에게 포인트를 부여(1점)");
	}
	
}





