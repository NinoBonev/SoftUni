<?php

/* base.html.twig */
class __TwigTemplate_a17f9d7aa975e34f4e0cc44eeab7f33089147d69ffdc6090114c99e26dfbd157 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
            'title' => array($this, 'block_title'),
            'stylesheets' => array($this, 'block_stylesheets'),
            'body_id' => array($this, 'block_body_id'),
            'body' => array($this, 'block_body'),
            'main' => array($this, 'block_main'),
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_c318cf641d8d1f16677d1e0c6d0d0c113799e5c7eca4d1e2776afb29a7e7da63 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_c318cf641d8d1f16677d1e0c6d0d0c113799e5c7eca4d1e2776afb29a7e7da63->enter($__internal_c318cf641d8d1f16677d1e0c6d0d0c113799e5c7eca4d1e2776afb29a7e7da63_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "base.html.twig"));

        $__internal_ac9e6f0272b1ae748aa886360cceb52ae996c4d67cc4def87530fe0f4f2bf580 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_ac9e6f0272b1ae748aa886360cceb52ae996c4d67cc4def87530fe0f4f2bf580->enter($__internal_ac9e6f0272b1ae748aa886360cceb52ae996c4d67cc4def87530fe0f4f2bf580_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "base.html.twig"));

        // line 6
        echo "<!DOCTYPE html>
<html lang=\"en-US\">
<head>
    <meta charset=\"UTF-8\"/>
    <title>";
        // line 10
        $this->displayBlock('title', $context, $blocks);
        echo "</title>
    ";
        // line 11
        $this->displayBlock('stylesheets', $context, $blocks);
        // line 16
        echo "    <link rel=\"icon\" type=\"image/x-icon\" href=\"";
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("favicon.ico"), "html", null, true);
        echo "\"/>
</head>

<body id=\"";
        // line 19
        $this->displayBlock('body_id', $context, $blocks);
        echo "\">
";
        // line 20
        $this->displayBlock('body', $context, $blocks);
        // line 23
        echo "</body>
</html>
";
        
        $__internal_c318cf641d8d1f16677d1e0c6d0d0c113799e5c7eca4d1e2776afb29a7e7da63->leave($__internal_c318cf641d8d1f16677d1e0c6d0d0c113799e5c7eca4d1e2776afb29a7e7da63_prof);

        
        $__internal_ac9e6f0272b1ae748aa886360cceb52ae996c4d67cc4def87530fe0f4f2bf580->leave($__internal_ac9e6f0272b1ae748aa886360cceb52ae996c4d67cc4def87530fe0f4f2bf580_prof);

    }

    // line 10
    public function block_title($context, array $blocks = array())
    {
        $__internal_a59fec12d02d5506dd4b75658cfe1a6883ce539f25b12aa2c3a63ac763ded014 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_a59fec12d02d5506dd4b75658cfe1a6883ce539f25b12aa2c3a63ac763ded014->enter($__internal_a59fec12d02d5506dd4b75658cfe1a6883ce539f25b12aa2c3a63ac763ded014_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "title"));

        $__internal_6354237d5bbdf3bc978dbe9bb8e91982326f334b8c220ac2e8887df005e89ef1 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_6354237d5bbdf3bc978dbe9bb8e91982326f334b8c220ac2e8887df005e89ef1->enter($__internal_6354237d5bbdf3bc978dbe9bb8e91982326f334b8c220ac2e8887df005e89ef1_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "title"));

        echo "Project Rider";
        
        $__internal_6354237d5bbdf3bc978dbe9bb8e91982326f334b8c220ac2e8887df005e89ef1->leave($__internal_6354237d5bbdf3bc978dbe9bb8e91982326f334b8c220ac2e8887df005e89ef1_prof);

        
        $__internal_a59fec12d02d5506dd4b75658cfe1a6883ce539f25b12aa2c3a63ac763ded014->leave($__internal_a59fec12d02d5506dd4b75658cfe1a6883ce539f25b12aa2c3a63ac763ded014_prof);

    }

    // line 11
    public function block_stylesheets($context, array $blocks = array())
    {
        $__internal_3be3fccdbf9cb0261107e751c984b957ae5dfdb1e5b1a9bb6a557d746be883c1 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_3be3fccdbf9cb0261107e751c984b957ae5dfdb1e5b1a9bb6a557d746be883c1->enter($__internal_3be3fccdbf9cb0261107e751c984b957ae5dfdb1e5b1a9bb6a557d746be883c1_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "stylesheets"));

        $__internal_d4ef7daa1a545c81f4da893c031a44ba1d787567f7c784e9f72688bf0468f200 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_d4ef7daa1a545c81f4da893c031a44ba1d787567f7c784e9f72688bf0468f200->enter($__internal_d4ef7daa1a545c81f4da893c031a44ba1d787567f7c784e9f72688bf0468f200_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "stylesheets"));

        // line 12
        echo "        <link rel=\"stylesheet\" href=\"";
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("css/reset.css"), "html", null, true);
        echo "\">
        <link rel=\"stylesheet\" href=\"";
        // line 13
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("css/style.css"), "html", null, true);
        echo "\">
        <link rel=\"stylesheet\" href=\"";
        // line 14
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("css/create-style.css"), "html", null, true);
        echo "\">
    ";
        
        $__internal_d4ef7daa1a545c81f4da893c031a44ba1d787567f7c784e9f72688bf0468f200->leave($__internal_d4ef7daa1a545c81f4da893c031a44ba1d787567f7c784e9f72688bf0468f200_prof);

        
        $__internal_3be3fccdbf9cb0261107e751c984b957ae5dfdb1e5b1a9bb6a557d746be883c1->leave($__internal_3be3fccdbf9cb0261107e751c984b957ae5dfdb1e5b1a9bb6a557d746be883c1_prof);

    }

    // line 19
    public function block_body_id($context, array $blocks = array())
    {
        $__internal_1c360c0fe45a6697d52357d25f84e59543584d61e87fe49b0c29491b5b8b24a3 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_1c360c0fe45a6697d52357d25f84e59543584d61e87fe49b0c29491b5b8b24a3->enter($__internal_1c360c0fe45a6697d52357d25f84e59543584d61e87fe49b0c29491b5b8b24a3_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body_id"));

        $__internal_0de07d67febc4731aae89583b10cd4a3f402949202e485eae867e24a758cab18 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_0de07d67febc4731aae89583b10cd4a3f402949202e485eae867e24a758cab18->enter($__internal_0de07d67febc4731aae89583b10cd4a3f402949202e485eae867e24a758cab18_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body_id"));

        
        $__internal_0de07d67febc4731aae89583b10cd4a3f402949202e485eae867e24a758cab18->leave($__internal_0de07d67febc4731aae89583b10cd4a3f402949202e485eae867e24a758cab18_prof);

        
        $__internal_1c360c0fe45a6697d52357d25f84e59543584d61e87fe49b0c29491b5b8b24a3->leave($__internal_1c360c0fe45a6697d52357d25f84e59543584d61e87fe49b0c29491b5b8b24a3_prof);

    }

    // line 20
    public function block_body($context, array $blocks = array())
    {
        $__internal_703b83629ce8017bf62ddbf1cc47bb3ca090d04bfafb0a515b029d711920c99c = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_703b83629ce8017bf62ddbf1cc47bb3ca090d04bfafb0a515b029d711920c99c->enter($__internal_703b83629ce8017bf62ddbf1cc47bb3ca090d04bfafb0a515b029d711920c99c_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body"));

        $__internal_4006d7ca28e7ec319ac5f8c50dc5a6e3a1eaa39d65b3da5768ddfa114840cb44 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_4006d7ca28e7ec319ac5f8c50dc5a6e3a1eaa39d65b3da5768ddfa114840cb44->enter($__internal_4006d7ca28e7ec319ac5f8c50dc5a6e3a1eaa39d65b3da5768ddfa114840cb44_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body"));

        // line 21
        echo "    ";
        $this->displayBlock('main', $context, $blocks);
        
        $__internal_4006d7ca28e7ec319ac5f8c50dc5a6e3a1eaa39d65b3da5768ddfa114840cb44->leave($__internal_4006d7ca28e7ec319ac5f8c50dc5a6e3a1eaa39d65b3da5768ddfa114840cb44_prof);

        
        $__internal_703b83629ce8017bf62ddbf1cc47bb3ca090d04bfafb0a515b029d711920c99c->leave($__internal_703b83629ce8017bf62ddbf1cc47bb3ca090d04bfafb0a515b029d711920c99c_prof);

    }

    public function block_main($context, array $blocks = array())
    {
        $__internal_14fe47fa7ee9d22e29ce5937848ff799c4bac4b77565fa82cc80a5ecb7b8118a = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_14fe47fa7ee9d22e29ce5937848ff799c4bac4b77565fa82cc80a5ecb7b8118a->enter($__internal_14fe47fa7ee9d22e29ce5937848ff799c4bac4b77565fa82cc80a5ecb7b8118a_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        $__internal_4a20f0d69b662f4d5526ad48584d966c7f644078d27ed83f464da153df0c047e = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_4a20f0d69b662f4d5526ad48584d966c7f644078d27ed83f464da153df0c047e->enter($__internal_4a20f0d69b662f4d5526ad48584d966c7f644078d27ed83f464da153df0c047e_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        
        $__internal_4a20f0d69b662f4d5526ad48584d966c7f644078d27ed83f464da153df0c047e->leave($__internal_4a20f0d69b662f4d5526ad48584d966c7f644078d27ed83f464da153df0c047e_prof);

        
        $__internal_14fe47fa7ee9d22e29ce5937848ff799c4bac4b77565fa82cc80a5ecb7b8118a->leave($__internal_14fe47fa7ee9d22e29ce5937848ff799c4bac4b77565fa82cc80a5ecb7b8118a_prof);

    }

    public function getTemplateName()
    {
        return "base.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  141 => 21,  132 => 20,  115 => 19,  103 => 14,  99 => 13,  94 => 12,  85 => 11,  67 => 10,  55 => 23,  53 => 20,  49 => 19,  42 => 16,  40 => 11,  36 => 10,  30 => 6,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("{#
   This is the base template used as the application layout which contains the
   common elements and decorates all the other templates.
   See http://symfony.com/doc/current/book/templating.html#template-inheritance-and-layouts
#}
<!DOCTYPE html>
<html lang=\"en-US\">
<head>
    <meta charset=\"UTF-8\"/>
    <title>{% block title %}Project Rider{% endblock %}</title>
    {% block stylesheets %}
        <link rel=\"stylesheet\" href=\"{{ asset('css/reset.css') }}\">
        <link rel=\"stylesheet\" href=\"{{ asset('css/style.css') }}\">
        <link rel=\"stylesheet\" href=\"{{ asset('css/create-style.css') }}\">
    {% endblock %}
    <link rel=\"icon\" type=\"image/x-icon\" href=\"{{ asset('favicon.ico') }}\"/>
</head>

<body id=\"{% block body_id %}{% endblock %}\">
{% block body %}
    {% block main %}{% endblock %}
{% endblock %}
</body>
</html>
", "base.html.twig", "C:\\Users\\NinoB\\Desktop\\teting\\app\\Resources\\views\\base.html.twig");
    }
}
