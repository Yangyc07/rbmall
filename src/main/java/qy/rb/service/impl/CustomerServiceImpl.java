package qy.rb.service.impl;

import java.util.UUID;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import qy.rb.common.ServerResponse;
import qy.rb.common.TokenCache;
import qy.rb.dao.CustomerDao;
import qy.rb.domain.Customer;
import qy.rb.domain.PageEntity;
import qy.rb.service.CustomerService;
import qy.rb.util.MD5Util;
import qy.rb.util.Pagenation;

/**
 * @author hjy
 * @create 2018/01/25
 *
 */
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerDao customerDao;

	@Override
	public ServerResponse<Customer> login(String loginName, String password) {
		boolean flag = customerDao.checkLoginName(loginName);
		if (!flag) {
			return ServerResponse.createByErrorMessage("用户名不存在");
		}

		String md5Password = MD5Util.MD5EncodeUtf8(password);
		Customer customer = customerDao.selecLogin(loginName, md5Password);
		if (customer == null) {
			return ServerResponse.createByErrorMessage("密码错误");
		}
		customer.setCustomerPassword(StringUtils.EMPTY);
		return ServerResponse.createBySuccess("登录成功", customer);
	}

	@Override
	public ServerResponse<String> register(Customer customer) {
		boolean flag = customerDao.checkLoginName(customer.getCustomerLoginName());
		if (flag) {
			return ServerResponse.createByErrorMessage("用户名已存在");
		}
		//加密
		customer.setCustomerPassword(MD5Util.MD5EncodeUtf8(customer.getCustomerPassword()));
		customer.setCustomerID("rb" + customer.getCustomerName());
		flag = customerDao.insertCustomer(customer);
		if (flag) {
			return ServerResponse.createBySuccessMessage("注册成功");
		}
		return ServerResponse.createByErrorMessage("注册失败");
	}

	@Override
	public ServerResponse selectQuestion(String loginName) {
		boolean flag = customerDao.checkLoginName(loginName);
		if (!flag) {
			return ServerResponse.createByErrorMessage("用户名不存在");
		}
		String question = customerDao.selectQuestionByLoginName(loginName);
		return ServerResponse.createBySuccess(question);
	}

	@Override
	public ServerResponse<String> checkAnswer(String loginName, String question, String answer) {
		boolean flag = customerDao.checkAnswer(loginName, question, answer);
		if (flag) {
			//说明问题及问题答案是这个用户的,并且是正确的
			String forgetToken = UUID.randomUUID().toString();
			TokenCache.setKey(TokenCache.TOKEN_PREFIX + loginName, forgetToken);
			return ServerResponse.createBySuccess(forgetToken);
		}
		return ServerResponse.createByErrorMessage("问题的答案错误");
	}

	@Override
	public ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken) {
		if (org.apache.commons.lang3.StringUtils.isBlank(forgetToken)) {
			return ServerResponse.createByErrorMessage("参数错误,token需要传递");
		}

		boolean flag = customerDao.checkLoginName(username);
		if (!flag) {
			//用户不存在
			return ServerResponse.createByErrorMessage("用户不存在");
		}
		String token = TokenCache.getKey(TokenCache.TOKEN_PREFIX + username);
		if (org.apache.commons.lang3.StringUtils.isBlank(token)) {
			return ServerResponse.createByErrorMessage("token无效或者过期");
		}

		if (org.apache.commons.lang3.StringUtils.equals(forgetToken, token)) {
			String md5Password = MD5Util.MD5EncodeUtf8(passwordNew);
			flag = customerDao.updateCustomerPassword(username, md5Password);
			if (flag) {
				return ServerResponse.createBySuccessMessage("修改密码成功");
			}
		} else {
			return ServerResponse.createByErrorMessage("token错误,请重新获取重置密码的token");
		}
		return ServerResponse.createByErrorMessage("修改密码失败");
	}


	@Override
	public Pagenation selectCustomerList(PageEntity pageEntity) {
		//算出所需数据的总条数
		int cout = customerDao.listCustomerDataRawCount(pageEntity);
		//通过（当前页、每页显示条数、总条数） 初始化分页信息
		Pagenation pagenation = new Pagenation(pageEntity.getPageSize(), pageEntity.getPageNum(), cout);
		//通过上步骤算出要查询的 开始条数，边set 到分页入参实体类中。
		pageEntity.setStartRow(pagenation.getStartRow());
		//在查询 list 的时候，让传入的startRow 和 pageSize 作为limit 条件，添加至 sql。
		pagenation.setList(customerDao.selectCustomerList(pageEntity));
		return pagenation;
	}

	@Override
	public Pagenation selectCustomerListByIdOrName(String customerId, String customerName, PageEntity pageEntity) {
		if (StringUtils.isNoneBlank(customerId)) {
			//customerId为空不执行
			customerId = new StringBuilder().append(customerId).append("%").toString();
		}
		if (StringUtils.isNoneBlank(customerName)) {
			//customerName为空不执行
			customerName = new StringBuilder().append(customerName).append("%").toString();
		}
		//算出所需数据的总条数
		int cout = customerDao.listCustomerDataRawCount(pageEntity);
		//通过（当前页、每页显示条数、总条数） 初始化分页信息
		Pagenation pagenation = new Pagenation(pageEntity.getPageSize(), pageEntity.getPageNum(), cout);
		//通过上步骤算出要查询的 开始条数，边set 到分页入参实体类中。
		pageEntity.setStartRow(pagenation.getStartRow());
		//在查询 list 的时候，让传入的startRow 和 pageSize 作为limit 条件，添加至 sql。
		pagenation.setList(customerDao.selectCustomerListByIdOrName(customerId, customerName, pageEntity));
		return pagenation;
	}

}
