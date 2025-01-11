

### 1. **广告主功能（Advertiser）**

广告主是系统的核心用户之一，负责管理广告内容和投放。以下是广告主的主要功能：

- **注册与登录**：广告主需要通过系统的注册功能创建一个账户，并且登录后使用所有功能。
- **广告内容管理**：
  - **创建广告**：广告主可以创建广告，输入广告的相关信息，包括标题、描述、图片、文字内容、网址（目标页面）、广告类型、广告分类、关键词等。
  - **编辑与删除广告**：广告主可以对已发布的广告进行修改，或者删除不再需要的广告。
  - **广告文件上传**：支持上传广告素材，如图片、视频、Logo等，并且能选择多种尺寸、格式。
- **广告投放**：
  - **选择投放位置**：广告主可以选择投放广告的位置（例如，网页顶部、侧边栏、弹窗等）。
  - **选择投放时段与频率**：可以设置广告投放的时间段、频率和投放日期。
  - **投放预算与优化**：广告主可以设置广告预算，选择投放效果优化策略。
- **广告效果监控与分析**：
  - **查看点击率**：广告主可以查看广告的点击率，转化率等基本数据。
  - **统计分析**：根据广告投放的时段（日、月、年）进行数据分析，了解广告的投放效果。
  - **收益分析**：广告主可以查看广告的收益情况，以及与广告相关的各类统计数据。
- **广告投放报告与可视化**：生成图表、报告等可视化内容，便于广告主快速了解广告的投放效果，并进行优化。

### 2. **互联网站长功能（Website Administrator）**

互联网站长作为系统的使用方，可以管理和查看广告的投放情况，分析广告的效果和收益。以下是他们的主要功能：

- **注册与登录**：与广告主类似，网站长也需要注册并登录账户。
- **查看广告**：
  - **广告浏览**：可以浏览已发布的广告，包括广告的名称、描述、目标网址、广告主信息等。
  - **广告API接口**：网站长可以访问广告的API接口，嵌入到网站中显示广告，支持广告的动态加载。
- **广告投放统计与数据分析**：
  - **查看广告投放情况**：查看不同广告的点击量、展示量、转化率等。
  - **收益统计**：查看广告投放带来的收益，包括每日、每周、每月的收益情况。
  - **广告效果分析**：根据不同的维度（时段、位置、广告类型等）对广告效果进行统计和分析。
- **可视化分析**：与广告主类似，网站长也可以进行数据的可视化，生成图表，进行趋势分析和报告生成。

### 3. **管理员功能（Admin）**

管理员是系统的最高权限角色，负责系统的整体管理。以下是管理员的主要功能：

- **用户管理**：
  - **广告主管理**：管理员可以查看、删除、禁用广告主账户，也可以管理广告主的权限。
  - **网站长管理**：管理员也可以管理网站长的账户和权限。
- **广告内容管理**：
  - **广告管理**：管理员可以查看所有广告的信息，包括广告主发布的所有广告。
  - **广告审核与管理**：管理员可以审核广告内容，确保其符合平台规范，避免发布不合规广告。
- **投放配置管理**：
  - **投放频率与时段配置**：管理员可以设置全站广告的投放频率，管理广告的投放时段、投放策略等。
  - **收益配置**：管理员可以设置广告收益的分配规则。
- **系统监控与报告**：
  - **查看系统统计信息**：管理员可以查看广告投放的整体情况，包括总的收益、广告展示量、点击量等。
  - **生成系统报告与可视化**：可以根据需求生成系统的运营报告，包括广告效果统计，收益分析等。
- **系统设置**：
  - **广告展示位置管理**：管理员可以管理广告展示位置，如广告在网页上的布局和优先级。
  - **安全与权限管理**：管理员负责管理整个系统的安全，设置不同用户角色的权限。

### 系统架构设计

1. **前端设计**（Vue 3）：
   - **广告管理页面**：广告主可以通过前端界面添加、编辑和删除广告。
   - **广告效果展示**：广告主可以查看广告的效果统计与分析，进行数据可视化。
   - **广告投放设置**：广告主设置广告投放的时间、频率、位置等。
   - **广告展示页面**：网站长通过前端展示广告，并提供广告点击的统计。
2. **后端设计**（Spring Boot）：
   - **用户与角色管理**：后端提供用户认证、授权等功能，确保不同角色有不同的权限。
   - **广告内容管理**：广告主上传广告素材，编辑广告内容，后端进行存储与管理。
   - **广告投放配置**：支持广告投放时段、位置、频率等配置，存储广告投放的相关数据。
   - **数据分析**：后端进行广告的统计与分析，提供广告效果、收益等数据接口。
   - **API接口**：为网站长提供广告展示接口，支持广告的动态加载和展示。

### 数据库设计

##### 1. 广告表

```mysql
CREATE TABLE Ad (
    id INT PRIMARY KEY AUTO_INCREMENT,       -- 广告的唯一标识
    title VARCHAR(255) NOT NULL,             -- 广告的标题
    description TEXT,                        -- 广告的描述
    image_url VARCHAR(255),                  -- 广告图片的URL
    target_url VARCHAR(255),                 -- 点击广告后跳转的URL
    category VARCHAR(100),                   -- 广告的分类
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 广告创建时间
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 广告更新时间
    status ENUM('active', 'paused', 'deleted') DEFAULT 'active' -- 广告状态（发布、暂停、删除）
);
```

##### 2.用户表

```mysql
CREATE TABLE User (
    id INT PRIMARY KEY AUTO_INCREMENT,       -- 用户的唯一标识
    username VARCHAR(255) NOT NULL UNIQUE,   -- 用户名，唯一
    password VARCHAR(255) NOT NULL,          -- 密码
    role ENUM('advertiser', 'webmaster', 'admin') NOT NULL, -- 用户角色（广告主、网站长、管理员）
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 用户创建时间
);

```

##### 3.广告投放记录表

```mysql
CREATE TABLE Ad_placement (
    id INT PRIMARY KEY AUTO_INCREMENT,       -- 投放记录的唯一标识
    ad_id INT,                               -- 关联的广告ID
    user_id INT,                             -- 广告主ID
    start_time TIMESTAMP,                    -- 广告投放开始时间
    end_time TIMESTAMP,                      -- 广告投放结束时间
    location VARCHAR(255),                   -- 广告展示的位置（例如：网页顶部、右侧等）
    FOREIGN KEY (ad_id) REFERENCES Ad(id)    -- 外键关联广告表
);
```

##### 4.广告效果统计表

```mysql
CREATE TABLE Ad_performance (
    id INT PRIMARY KEY AUTO_INCREMENT,       -- 统计记录的唯一标识
    ad_id INT,                               -- 关联的广告ID
    click_count INT DEFAULT 0,               -- 广告点击次数
    impression_count INT DEFAULT 0,          -- 广告展示次数
    date DATE,                               -- 统计日期
    FOREIGN KEY (ad_id) REFERENCES Ad(id)    -- 外键关联广告表
);

```
