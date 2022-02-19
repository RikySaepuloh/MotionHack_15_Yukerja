package id.motionhack.yukerja.domain.model

data class DashboardItem(
	val title: String,
	val employer: String,
	val duration: String,
	val verified: Boolean,
	val disability: Boolean,
	val salary: String
)

