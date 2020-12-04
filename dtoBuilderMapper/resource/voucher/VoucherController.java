@Controller
@RequestMapping("/resource")
public class VoucherController {
	@Autowired
	ConfigureRepository configureRepository;
	@Autowired
	VoucherService voucherService;
  	@Autowired
	LoggerService loggerService;

	//refactoring
	@RequestMapping(value = "/voucher", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "바우처 등록")
	public VoucherDto.CreateRes saveVoucherInfo(@RequestBody @Valid VoucherDto.CreateReq createVoucherReq) throws Exception {
		return voucherService.saveVoucherInfo(createVoucherReq);
	}

	//refactoring
	@RequestMapping(value = "/voucher", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "바우처 갱신")
	public VoucherDto.UpdateRes updateVoucherInfo(@RequestBody @Valid VoucherDto.UpdateReq updateVoucherInfo) throws Exception {
		return voucherService.updateVoucherInfo(updateVoucherInfo);
	}
}
